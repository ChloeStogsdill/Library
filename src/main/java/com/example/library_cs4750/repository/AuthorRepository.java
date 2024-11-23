package com.example.library_cs4750.repository;

import com.example.library_cs4750.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AuthorRepository extends JpaRepository<Author, Long> {

    // Custom query to find all authors for a specific book by ISBN
//    @Query("SELECT a FROM Author a JOIN AuthorToBook ab ON a.authorId = ab.author.authorId WHERE ab.book.isbn = :isbn")
//    List<Author> findAuthorsByBookISBN(String isbn);

    // Method to find authors by their first or last name
    List<Author> findByFirstNameContainingOrLastNameContaining(String firstName, String lastName);
}
