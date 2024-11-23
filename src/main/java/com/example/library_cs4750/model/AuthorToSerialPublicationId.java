//package com.example.library_cs4750.model;
//
//import jakarta.persistence.*;
//import java.io.Serializable;
//import java.util.Objects;
//
//@Embeddable
//public class AuthorToSerialPublicationId implements Serializable {
//
//    @Column(name = "AuthorID")
//    private int authorId;
//
//    @Column(name = "ISSN", length = 8)
//    private String issn;
//
//    public AuthorToSerialPublicationId() {}
//
//    public AuthorToSerialPublicationId(int authorId, String issn) {
//        this.authorId = authorId;
//        this.issn = issn;
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
//    public String getIssn() {
//        return issn;
//    }
//
//    public void setIssn(String issn) {
//        this.issn = issn;
//    }
//
//    // Override equals and hashCode for composite key
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        AuthorToSerialPublicationId that = (AuthorToSerialPublicationId) o;
//        return authorId == that.authorId && Objects.equals(issn, that.issn);
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(authorId, issn);
//    }
//}
