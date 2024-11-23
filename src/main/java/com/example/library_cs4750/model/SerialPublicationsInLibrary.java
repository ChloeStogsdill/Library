//package com.example.library_cs4750.model;
//
//import jakarta.persistence.*;
//
//@Entity
//@Table(name = "SerialPublicationsInLibrary")
//public class SerialPublicationsInLibrary {
//
//    @EmbeddedId
//    private SerialPublicationsInLibraryId id;
//
//    @ManyToOne
//    @MapsId("libraryId")
//    @JoinColumn(name = "LibraryID")
//    private Library library;
//
//    @ManyToOne
//    @MapsId("issn")
//    @JoinColumn(name = "ISSN")
//    private SerialPublication serialPublication;
//
//    public SerialPublicationsInLibrary() {}
//
//    public SerialPublicationsInLibrary(Library library, SerialPublication serialPublication) {
//        this.library = library;
//        this.serialPublication = serialPublication;
//        this.id = new SerialPublicationsInLibraryId(library.getLibraryId(), serialPublication.getIssn());
//    }
//
//    public SerialPublicationsInLibraryId getId() {
//        return id;
//    }
//
//    public void setId(SerialPublicationsInLibraryId id) {
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
//    public SerialPublication getSerialPublication() {
//        return serialPublication;
//    }
//
//    public void setSerialPublication(SerialPublication serialPublication) {
//        this.serialPublication = serialPublication;
//    }
//}
