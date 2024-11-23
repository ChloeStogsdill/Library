//package com.example.library_cs4750.model;
//
//import jakarta.persistence.*;
//import java.io.Serializable;
//import java.util.Objects;
//
//@Embeddable
//public class SerialPublicationsInLibraryId implements Serializable {
//
//    @Column(name = "LibraryID")
//    private int libraryId;
//
//    @Column(name = "ISSN", length = 8)
//    private String issn;
//
//    public SerialPublicationsInLibraryId() {}
//
//    public SerialPublicationsInLibraryId(int libraryId, String issn) {
//        this.libraryId = libraryId;
//        this.issn = issn;
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
//        SerialPublicationsInLibraryId that = (SerialPublicationsInLibraryId) o;
//        return libraryId == that.libraryId && Objects.equals(issn, that.issn);
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(libraryId, issn);
//    }
//}
