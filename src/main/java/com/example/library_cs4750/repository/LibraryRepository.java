package com.example.library_cs4750.repository;

import com.example.library_cs4750.model.Library;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface LibraryRepository extends JpaRepository<Library, Integer> {

    // Find a library by its name
    Optional<Library> findByName(String name);

    // Find libraries that contain a part of a name (case-insensitive search)
    List<Library> findByNameContainingIgnoreCase(String name);
}
