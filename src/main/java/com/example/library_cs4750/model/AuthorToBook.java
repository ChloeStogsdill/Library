//package com.example.library_cs4750.model;
//
//import jakarta.persistence.*;
//
//@Entity
//@Table(name = "AuthorToBook")
//public class AuthorToBook {
//
//    @EmbeddedId
//    private AuthorToBookId id;
//
//    @ManyToOne
//    @MapsId("authorId")
//    @JoinColumn(name = "AuthorID")
//    private Author author;
//
//    @ManyToOne
//    @MapsId("isbn")
//    @JoinColumn(name = "ISBN")
//    private Book book;
//
//    public AuthorToBook() {}
//
//    public AuthorToBook(Author author, Book book) {
//        this.author = author;
//        this.book = book;
//        this.id = new AuthorToBookId(author.getAuthorId(), book.getIsbn());
//    }
//
//    public AuthorToBookId getId() {
//        return id;
//    }
//
//    public void setId(AuthorToBookId id) {
//        this.id = id;
//    }
//
//    public Author getAuthor() {
//        return author;
//    }
//
//    public void setAuthor(Author author) {
//        this.author = author;
//    }
//
//    public Book getBook() {
//        return book;
//    }
//
//    public void setBook(Book book) {
//        this.book = book;
//    }
//}
