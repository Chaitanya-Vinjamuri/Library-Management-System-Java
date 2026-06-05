package org.library.model;

import java.time.LocalDateTime;

public abstract class LibraryItem {
    private String id;
    private String title;
    private String genre;
    private LocalDateTime addedAt;

    public LibraryItem(String id, String title,String genre) {
        this.genre = genre;
        this.id = id;   
        this.title = title;
        this.addedAt = LocalDateTime.now();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public LocalDateTime getAddedAt() {
        return addedAt;
    }

    public void setAddedAt(LocalDateTime addedAt) {
        this.addedAt = addedAt;
    }

    public abstract void display();
}
