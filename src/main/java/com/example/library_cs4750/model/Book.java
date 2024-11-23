package com.example.library_cs4750.model;

import jakarta.persistence.*;


@Entity
@Table(name = "Book")
public class Book {

    @Id
    @Column(name = "ISBN", length = 13)
    private String isbn;

    @Column(name = "Title", length = 100)
    private String title;

    @Column(name = "Publisher", length = 100)
    private String publisher;

    @Column(name = "Genre", length = 50)
    private String genre;

    @Column(name = "Subject", length = 100)
    private String subject;

    @Column(name = "Edition")
    private Integer edition;

    public Book() {
    }

    public Book(String isbn, String title, String publisher, String genre, String subject, Integer edition) {
        this.isbn = isbn;
        this.title = title;
        this.publisher = publisher;
        this.genre = genre;
        this.subject = subject;
        this.edition = edition;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public Integer getEdition() {
        return edition;
    }

    public void setEdition(Integer edition) {
        this.edition = edition;
    }
}