//package com.example.library_cs4750.model;
//
//import jakarta.persistence.*;
//import java.io.Serializable;
//import java.util.Objects;
//
//@Embeddable
//public class UsersToLibraryId implements Serializable {
//
//    @Column(name = "Username", length = 50)
//    private String username;
//
//    @Column(name = "LibraryID")
//    private int libraryId;
//
//    public UsersToLibraryId() {}
//
//    public UsersToLibraryId(String username, int libraryId) {
//        this.username = username;
//        this.libraryId = libraryId;
//    }
//
//    // Getters and Setters
//    public String getUsername() {
//        return username;
//    }
//
//    public void setUsername(String username) {
//        this.username = username;
//    }
//
//    public int getLibraryId() {
//        return libraryId;
//    }
//
//    public void setLibraryId(int libraryId) {
//        this.libraryId = libraryId;
//    }
//
//    // Override equals and hashCode for composite key
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        UsersToLibraryId that = (UsersToLibraryId) o;
//        return libraryId == that.libraryId && Objects.equals(username, that.username);
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(username, libraryId);
//    }
//}
