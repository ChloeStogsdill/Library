//package com.example.library_cs4750.model;
//
//import jakarta.persistence.*;
//
//@Entity
//@Table(name = "BooksInLibrary")
//public class BooksInLibrary {
//
//    @EmbeddedId
//    private BooksInLibraryId id;
//
//    @ManyToOne
//    @MapsId("libraryId")
//    @JoinColumn(name = "LibraryID")
//    private Library library;
//
//    @ManyToOne
//    @MapsId("isbn")
//    @JoinColumn(name = "ISBN")
//    private Book book;
//
//    public BooksInLibrary() {}
//
//    public BooksInLibrary(Library library, Book book) {
//        this.library = library;
//        this.book = book;
//        this.id = new BooksInLibraryId(library.getLibraryId(), book.getIsbn());
//    }
//
//    public BooksInLibraryId getId() {
//        return id;
//    }
//
//    public void setId(BooksInLibraryId id) {
//        this.id = id;
//    }
//
//    public Library getLibrary() {
//        return library;
//    }
//
//    public void setLibrary(Library library) {
//        this.library = library;
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
