package com.example.library_cs4750.model;

import jakarta.persistence.*;

@Entity
@Table(name = "Users")
public class Users {

    @Id
    @Column(name = "UserID")
    private int userId;

    @Column(name = "Username", length = 50)
    private String username;

    @Column(name = "FirstName", length = 50)
    private String firstName;

    @Column(name = "LastName", length = 50)
    private String lastName;

    @Column(name = "Email", length = 100, unique = true)
    private String email;

    @Column(name = "Password", length = 255)
    private String password;

    public Users() {
    }

    public Users(int userId, String username, String firstName, String lastName, String email, String password) {
        this.userId = userId;
        this.username = username;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
    }

    public int getUserId(){return userId;}

    public void setUserId(int userId){this.userId = userId;}

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
