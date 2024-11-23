//package com.example.library_cs4750.model;
//
//import jakarta.persistence.*;
//import java.io.Serializable;
//import java.util.Objects;
//
//@Embeddable
//public class BooksInLibraryId implements Serializable {
//
//    @Column(name = "LibraryID")
//    private int libraryId;
//
//    @Column(name = "ISBN", length = 13)
//    private String isbn;
//
//    public BooksInLibraryId() {}
//
//    public BooksInLibraryId(int libraryId, String isbn) {
//        this.libraryId = libraryId;
//        this.isbn = isbn;
//    }
//
//    // Getters and Setters
//    public int getLibraryId() {
//        return libraryId;
//    }
//
//    public void setLibraryId(int libraryId) {
//        this.libraryId = libraryId;
//    }
//
//    public String getIsbn() {
//        return isbn;
//    }
//
//    public void setIsbn(String isbn) {
//        this.isbn = isbn;
//    }
//
//    // Override equals and hashCode for composite key
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        BooksInLibraryId that = (BooksInLibraryId) o;
//        return libraryId == that.libraryId && Objects.equals(isbn, that.isbn);
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(libraryId, isbn);
//    }
//}
