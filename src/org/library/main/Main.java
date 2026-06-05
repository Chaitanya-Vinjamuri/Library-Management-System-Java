package org.library.main;

import org.library.model.Book;
import org.library.model.Member;
import org.library.service.LibraryService;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        LibraryService service =
                new LibraryService();

        /*
         * Sample Books
         * 6 books across 3 genres
         */

        // Programming
        service.addBook(
                new Book(
                        "B101",
                        "Java Fundamentals",
                        "Programming",
                        "James Gosling",
                        "ISBN101"
                )
        );

        service.addBook(
                new Book(
                        "B102",
                        "Spring Boot",
                        "Programming",
                        "Rod Johnson",
                        "ISBN102"
                )
        );

        // Database
        service.addBook(
                new Book(
                        "B103",
                        "MySQL Guide",
                        "Database",
                        "Paul Dubois",
                        "ISBN103"
                )
        );

        service.addBook(
                new Book(
                        "B104",
                        "SQL Mastery",
                        "Database",
                        "Alan Beaulieu",
                        "ISBN104"
                )
        );

        // Design
        service.addBook(
                new Book(
                        "B105",
                        "Design Patterns",
                        "Design",
                        "Gang of Four",
                        "ISBN105"
                )
        );

        service.addBook(
                new Book(
                        "B106",
                        "Clean Architecture",
                        "Design",
                        "Robert Martin",
                        "ISBN106"
                )
        );

        /*
         * Sample Members
         * 3 registered members
         */

        service.addMember(
                new Member(
                        "M101",
                        "Chaitanya",
                        "chaitanya@gmail.com"
                )
        );

        service.addMember(
                new Member(
                        "M102",
                        "Rahul",
                        "rahul@gmail.com"
                )
        );

        service.addMember(
                new Member(
                        "M103",
                        "Priya",
                        "priya@gmail.com"
                )
        );

        Scanner scanner =
                new Scanner(System.in);

        int choice;

        do {

            System.out.println(
                    "\n================================="
            );
            System.out.println(
                    " LIBRARY MANAGEMENT SYSTEM "
            );
            System.out.println(
                    "================================="
            );
            System.out.println(
                    "1. Display All Books"
            );
            System.out.println(
                    "2. Search Book By Author"
            );
            System.out.println(
                    "3. Show Available Books"
            );
            System.out.println(
                    "4. Borrow Book"
            );
            System.out.println(
                    "5. Return Book"
            );
            System.out.println(
                    "6. Group Books By Genre"
            );
            System.out.println(
                    "7. Sort Books By Title"
            );
            System.out.println(
                    "8. Exit"
            );

            System.out.print(
                    "Enter Choice : "
            );

            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {

                case 1:

                    service.displayBooks();
                    break;

                case 2:

                    System.out.print(
                            "Enter Author Name : "
                    );

                    String author =
                            scanner.nextLine();

                    service.searchByAuthor(author)
                            .getResults()
                            .forEach(Book::display);

                    break;

                case 3:

                    service.getAvailableBooks()
                            .forEach(Book::display);

                    break;

                case 4:

                    System.out.print(
                            "Enter Member ID : "
                    );

                    String memberId =
                            scanner.nextLine();

                    System.out.print(
                            "Enter Book ID : "
                    );

                    String borrowBookId =
                            scanner.nextLine();

                    try {

                        service.borrowBook(
                                memberId,
                                borrowBookId
                        );

                    } catch (Exception e) {

                        System.out.println(
                                e.getMessage()
                        );
                    }

                    break;

                case 5:

                    System.out.print(
                            "Enter Member ID : "
                    );

                    String returnMemberId =
                            scanner.nextLine();

                    System.out.print(
                            "Enter Book ID : "
                    );

                    String returnBookId =
                            scanner.nextLine();

                    try {

                        service.returnBook(
                                returnMemberId,
                                returnBookId
                        );

                    } catch (Exception e) {

                        System.out.println(
                                e.getMessage()
                        );
                    }

                    break;

                case 6:

                    service.groupByGenre()
                            .forEach(
                                    (genre, books) -> {

                                        System.out.println(
                                                "\nGenre : "
                                                        + genre
                                        );

                                        books.forEach(
                                                Book::display
                                        );
                                    }
                            );

                    break;

                case 7:

                    service.getSortedByTitle()
                            .forEach(Book::display);

                    break;

                case 8:

                    System.out.println(
                            "Thank You For Using Library Management System"
                    );

                    break;

                default:

                    System.out.println(
                            "Invalid Choice"
                    );
            }

        } while (choice != 8);

        scanner.close();
    }
}