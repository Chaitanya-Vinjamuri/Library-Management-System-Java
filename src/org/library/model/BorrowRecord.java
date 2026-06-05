package org.library.model;

import java.time.LocalDateTime;

public class BorrowRecord {

    private Book book;
    private Member member;
    private LocalDateTime borrowedAt;
    private LocalDateTime returnedAt;

    public BorrowRecord(
            Book book,
            Member member,
            LocalDateTime borrowedAt) {

        this.book = book;
        this.member = member;
        this.borrowedAt = borrowedAt;
    }

    public Book getBook() {
        return book;
    }

    public Member getMember() {
        return member;
    }

    public LocalDateTime getBorrowedAt() {
        return borrowedAt;
    }

    public LocalDateTime getReturnedAt() {
        return returnedAt;
    }

    public void setReturnedAt(
            LocalDateTime returnedAt) {

        this.returnedAt = returnedAt;
    }
}