package org.library.service;

import org.library.exception.BookNotAvailableException;
import org.library.exception.BookNotFoundException;
import org.library.exception.MemberNotFoundException;
import org.library.catalog.LibraryCatalog;
import org.library.catalog.SearchResult;
import org.library.model.*;

import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

public class LibraryService {

    private LibraryCatalog<Book> catalog;

    private Map<String, Member> members;

    private Set<String> genres;

    private Queue<BorrowRequest> borrowRequests;

    private List<BorrowRecord> borrowRecords;

    public LibraryService() {

        catalog = new LibraryCatalog<>();

        members = new HashMap<>();

        genres = new HashSet<>();

        borrowRequests = new LinkedList<>();

        borrowRecords = new ArrayList<>();
    }

    public void addBook(Book book) {

        catalog.add(book);

        genres.add(book.getGenre());

        System.out.println(
                "Book added : "
                        + book.getTitle()
        );
    }

    public void addMember(Member member) {

        members.put(
                member.getMemberId(),
                member
        );

        System.out.println(
                "Member added : "
                        + member.getName()
        );
    }

    public void displayBooks() {

        catalog.getItems()
                .forEach(
                        LibraryItem::display
                );
    }

    public SearchResult<Book>
    searchByAuthor(String author) {

        List<Book> results =

                catalog.getItems()
                        .stream()
                        .filter(book ->
                                book.getAuthor()
                                        .equalsIgnoreCase(author))
                        .collect(Collectors.toList());

        return new SearchResult<>(
                results,
                author
        );
    }

    public List<Book> getAvailableBooks() {

        return catalog.getItems()
                .stream()
                .filter(Book::isAvailable)
                .collect(Collectors.toList());
    }

    public List<Book> getSortedByTitle() {

        return catalog.getItems()
                .stream()
                .sorted(
                        Comparator.comparing(
                                Book::getTitle
                        )
                )
                .collect(Collectors.toList());
    }

    public Map<String, List<Book>>
    groupByGenre() {

        return catalog.getItems()
                .stream()
                .collect(
                        Collectors.groupingBy(
                                Book::getGenre
                        )
                );
    }

    public void borrowBook(
            String memberId,
            String bookId)
            throws BookNotAvailableException {

        Member member =
                members.get(memberId);

        if(member == null) {

            throw new MemberNotFoundException(
                    "Member not found"
            );
        }

        Book book =

                catalog.getItems()
                        .stream()
                        .filter(b ->
                                b.getId()
                                        .equals(bookId))
                        .findFirst()
                        .orElseThrow(() ->
                                new BookNotFoundException(
                                        "Book not found"
                                ));

        if(!book.isAvailable()) {

            borrowRequests.offer(

                    new BorrowRequest(
                            member,
                            book,
                            LocalDateTime.now()
                    )
            );

            throw new BookNotAvailableException(
                    "Book already borrowed. Request queued."
            );
        }

        book.borrow();

        BorrowRecord record =
                new BorrowRecord(
                        book,
                        member,
                        LocalDateTime.now()
                );

        borrowRecords.add(record);

        member.getBorrowHistory()
                .add(record);

        System.out.println(
                book.getTitle()
                        + " borrowed successfully"
        );
    }

    public void returnBook(
            String memberId,
            String bookId) {

        Member member =
                members.get(memberId);

        if(member == null) {

            throw new MemberNotFoundException(
                    "Member not found"
            );
        }

        Book book =

                catalog.getItems()
                        .stream()
                        .filter(b ->
                                b.getId()
                                        .equals(bookId))
                        .findFirst()
                        .orElseThrow(() ->
                                new BookNotFoundException(
                                        "Book not found"
                                ));

        book.returnItem();

        for(BorrowRecord record
                : borrowRecords) {

            if(record.getBook()
                    .getId()
                    .equals(bookId)

                    &&

                    record.getReturnedAt()
                            == null) {

                record.setReturnedAt(
                        LocalDateTime.now()
                );

                break;
            }
        }

        System.out.println(
                book.getTitle()
                        + " returned successfully"
        );

        processBorrowRequests(book);
    }

    private void processBorrowRequests(
            Book returnedBook) {

        Iterator<BorrowRequest> iterator =
                borrowRequests.iterator();

        while(iterator.hasNext()) {

            BorrowRequest request =
                    iterator.next();

            if(request.getBook()
                    .getId()
                    .equals(
                            returnedBook.getId()
                    )) {

                returnedBook.borrow();

                BorrowRecord record =
                        new BorrowRecord(
                                returnedBook,
                                request.getMember(),
                                LocalDateTime.now()
                        );

                borrowRecords.add(record);

                request.getMember()
                        .getBorrowHistory()
                        .add(record);

                iterator.remove();

                System.out.println(
                        "Queued request processed for "
                                + request.getMember()
                                .getName()
                );

                break;
            }
        }
    }
}