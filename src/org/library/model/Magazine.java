package org.library.model;

public class Magazine extends LibraryItem {

    private int issueNumber;
    private String publisher;

    public Magazine(String id,
                    String title,
                    String genre,
                    int issueNumber,
                    String publisher) {

        super(id, title, genre);

        this.issueNumber = issueNumber;
        this.publisher = publisher;
    }

    public int getIssueNumber() {
        return issueNumber;
    }

    public String getPublisher() {
        return publisher;
    }

    @Override
    public void display() {

        System.out.println(
                "Magazine : " + getTitle() +
                        " | Issue : " + issueNumber +
                        " | Publisher : " + publisher
        );
    }
}