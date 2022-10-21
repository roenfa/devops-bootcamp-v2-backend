package org.devops.bootcamp.models;

public class Book {
    private Long id;
    private String title;
    private String author;
    private String number;

    public Book(String title, String author, String number) {
        this.title = title;
        this.author = author;
        this.number = number;
    }
}