//package com.example.library_cs4750.model;
//
//import jakarta.persistence.*;
//
//@Entity
//@Table(name = "AuthorToSerialPublication")
//public class AuthorToSerialPublication {
//
//    @EmbeddedId
//    private AuthorToSerialPublicationId id;
//
//    @ManyToOne
//    @MapsId("authorId")
//    @JoinColumn(name = "AuthorID")
//    private Author author;
//
//    @ManyToOne
//    @MapsId("issn")
//    @JoinColumn(name = "ISSN")
//    private SerialPublication serialPublication;
//
//    public AuthorToSerialPublication() {}
//
//    public AuthorToSerialPublication(Author author, SerialPublication serialPublication) {
//        this.author = author;
//        this.serialPublication = serialPublication;
//        this.id = new AuthorToSerialPublicationId(author.getAuthorId(), serialPublication.getIssn());
//    }
//
//    public AuthorToSerialPublicationId getId() {
//        return id;
//    }
//
//    public void setId(AuthorToSerialPublicationId id) {
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
//    public SerialPublication getSerialPublication() {
//        return serialPublication;
//    }
//
//    public void setSerialPublication(SerialPublication serialPublication) {
//        this.serialPublication = serialPublication;
//    }
//}
