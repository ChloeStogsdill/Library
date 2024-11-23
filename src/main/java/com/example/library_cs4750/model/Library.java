package com.example.library_cs4750.model;

import jakarta.persistence.*;

@Entity
@Table(name = "Library")
public class Library {

    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "LibraryID")
    private int libraryId;

    @Column(name = "Name", length = 100)
    private String name;

    public Library() {
    }

    public Library(int libraryId, String name) {
        this.libraryId = libraryId;
        this.name = name;
    }

    public int getLibraryId() {
        return libraryId;
    }

    public void setLibraryId(int libraryId) {
        this.libraryId = libraryId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
