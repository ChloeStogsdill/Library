package com.example.library_cs4750.controller;

import com.example.library_cs4750.model.Users;
import com.example.library_cs4750.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class UsersController {

    @Autowired
    private UsersRepository usersRepository;

    // Get all users or filter by name
    @GetMapping("/users")
    public ResponseEntity<List<Users>> getAllUsers(@RequestParam(required = false) String name) {
        try {
            List<Users> users;

            if (name == null) {
                users = usersRepository.findAll();
            } else {
                users = usersRepository.findByFirstNameContainingOrLastNameContaining(name, name);
            }

            if (users.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(users, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Get a user by their ID
    @GetMapping("/users/{id}")
    public ResponseEntity<Users> getUserById(@PathVariable("id") int id) {
        Optional<Users> userData = usersRepository.findByUserId(id);

        return userData.map(user -> new ResponseEntity<>(user, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

//    // Get a user by their username
//    @GetMapping("/users/username/{username}")
//    public ResponseEntity<Users> getUserByUsername(@PathVariable("username") String username) {
//        Optional<Users> usersData = usersRepository.findByUsername(username);
//
//        return usersData.map(user -> new ResponseEntity<>(user, HttpStatus.OK))
//                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
//    }

    // Create a new user
    @PostMapping("/users")
    public ResponseEntity<Users> createUser(@RequestBody Users user) {
        try {
            Users _user = usersRepository.save(new Users(user.getUserId(), user.getUsername(), user.getPassword(), user.getFirstName(), user.getLastName(), user.getEmail()));
            return new ResponseEntity<>(_user, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Update an existing user
    @PutMapping("/users/{id}")
    public ResponseEntity<Users> updateUser(@PathVariable("id") Long id, @RequestBody Users user) {
        Optional<Users> userData = usersRepository.findById(id);

        if (userData.isPresent()) {
            Users _user = userData.get();
            _user.setUserId(user.getUserId());
            _user.setUsername(user.getUsername());
            _user.setPassword(user.getPassword());
            _user.setFirstName(user.getFirstName());
            _user.setLastName(user.getLastName());
            _user.setEmail(user.getEmail());

            return new ResponseEntity<>(usersRepository.save(_user), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Delete a user by their ID
    @DeleteMapping("/users/{id}")
    public ResponseEntity<HttpStatus> deleteUser(@PathVariable("id") Long id) {
        try {
            usersRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Delete all users
    @DeleteMapping("/users")
    public ResponseEntity<HttpStatus> deleteAllUsers() {
        try {
            usersRepository.deleteAll();
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
