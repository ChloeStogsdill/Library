//package com.example.library_cs4750.model;
//
//import jakarta.persistence.*;
//
//@Entity
//@Table(name = "UsersToLibrary")
//public class UsersToLibrary {
//
//    @EmbeddedId
//    private UsersToLibraryId id;
//
//    @ManyToOne
//    @MapsId("username")
//    @JoinColumn(name = "Username")
//    private Users user;
//
//    @ManyToOne
//    @MapsId("libraryId")
//    @JoinColumn(name = "LibraryID")
//    private Library library;
//
//    public UsersToLibrary() {}
//
//    public UsersToLibrary(Users user, Library library) {
//        this.user = user;
//        this.library = library;
//        this.id = new UsersToLibraryId(user.getUsername(), library.getLibraryId());
//    }
//
//    public UsersToLibraryId getId() {
//        return id;
//    }
//
//    public void setId(UsersToLibraryId id) {
//        this.id = id;
//    }
//
//    public Users getUser() {
//        return user;
//    }
//
//    public void setUser(Users user) {
//        this.user = user;
//    }
//
//    public Library getLibrary() {
//        return library;
//    }
//
//    public void setLibrary(Library library) {
//        this.library = library;
//    }
//}
