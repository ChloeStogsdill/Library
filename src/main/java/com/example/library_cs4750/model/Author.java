package com.example.library_cs4750.model;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "Author")
public class Author {

    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "AuthorID")
    private int authorId;

    @Column(name = "FirstName", length = 50)
    private String firstName;

    @Column(name = "LastName", length = 50)
    private String lastName;

    @Column(name = "DOB")
    @Temporal(TemporalType.DATE)
    private Date dob;

    @Column(name = "DOD")
    @Temporal(TemporalType.DATE)
    private Date dod;

    public Author() {
    }

    public Author(int authorId, String firstName, String lastName, Date dob, Date dod) {
        this.authorId = authorId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dob = dob;
        this.dod = dod;
    }

    public int getAuthorId() {
        return authorId;
    }

    public void setAuthorId(int authorId) {
        this.authorId = authorId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public Date getDod() {
        return dod;
    }

    public void setDod(Date dod) {
        this.dod = dod;
    }
}
