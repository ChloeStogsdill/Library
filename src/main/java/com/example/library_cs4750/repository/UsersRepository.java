package com.example.library_cs4750.repository;

import com.example.library_cs4750.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UsersRepository extends JpaRepository<Users, Long> {

    // Find a user by their username (if the User class has a username field)
    Optional<Users> findByUserId(int userId);

    // Find users by part of their first or last name
    List<Users> findByFirstNameContainingOrLastNameContaining(String firstName, String lastName);
}
