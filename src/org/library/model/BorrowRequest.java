package org.library.model;

import java.time.LocalDateTime;

public class BorrowRequest {

    private Member member;
    private Book book;
    private LocalDateTime requestedAt;

    public BorrowRequest(
            Member member,
            Book book,
            LocalDateTime requestedAt) {

        this.member = member;
        this.book = book;
        this.requestedAt = requestedAt;
    }

    public Member getMember() {
        return member;
    }

    public Book getBook() {
        return book;
    }

    public LocalDateTime getRequestedAt() {
        return requestedAt;
    }
}