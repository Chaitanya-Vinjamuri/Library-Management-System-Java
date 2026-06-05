package org.library.model;

import org.library.interfaces.Borrowable;

public class Book extends LibraryItem
        implements Borrowable {

    private String author;
    private String isbn;
    private boolean available;

    public Book(String id,
                String title,
                String genre,
                String author,
                String isbn) {

        super(id, title, genre);

        this.author = author;
        this.isbn = isbn;
        this.available = true;
    }

    public String getAuthor() {
        return author;
    }

    public String getIsbn() {
        return isbn;
    }

 
    public void borrow() {
        available = false;
    }

 
    public void returnItem() {
        available = true;
    }

 
    public boolean isAvailable() {
        return available;
    }

 
    public void display() {

        System.out.println(
                "Book : " + getTitle() +
                        " | Author : " + author +
                        " | Genre : " + getGenre()
        );
    }
}