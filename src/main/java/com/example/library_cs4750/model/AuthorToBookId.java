//package com.example.library_cs4750.model;
//
//import jakarta.persistence.*;
//import java.io.Serializable;
//import java.util.Objects;
//
//@Embeddable
//public class AuthorToBookId implements Serializable {
//
//    @Column(name = "AuthorID")
//    private int authorId;
//
//    @Column(name = "ISBN", length = 13)
//    private String isbn;
//
//    public AuthorToBookId() {}
//
//    public AuthorToBookId(int authorId, String isbn) {
//        this.authorId = authorId;
//        this.isbn = isbn;
//    }
//
//    // Getters and Setters
//    public int getAuthorId() {
//        return authorId;
//    }
//
//    public void setAuthorId(int authorId) {
//        this.authorId = authorId;
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
//        AuthorToBookId that = (AuthorToBookId) o;
//        return authorId == that.authorId && Objects.equals(isbn, that.isbn);
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(authorId, isbn);
//    }
//}
