package com.example.library_cs4750.controller;

import com.example.library_cs4750.model.Author;
import com.example.library_cs4750.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class AuthorController {

    @Autowired
    private AuthorRepository authorRepository;

    // Get all authors or filter by name
    @GetMapping("/authors")
    public ResponseEntity<List<Author>> getAllAuthors(@RequestParam(required = false) String name) {
        try {
            List<Author> authors;

            if (name == null) {
                authors = authorRepository.findAll();
            } else {
                authors = authorRepository.findByFirstNameContainingOrLastNameContaining(name, name);
            }

            if (authors.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(authors, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Get an author by their ID
    @GetMapping("/authors/{id}")
    public ResponseEntity<Author> getAuthorById(@PathVariable("id") Long id) {
        Optional<Author> authorData = authorRepository.findById(id);

        return authorData.map(author -> new ResponseEntity<>(author, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // Get authors by a book's ISBN
//    @GetMapping("/authors/book/{isbn}")
//    public ResponseEntity<List<Author>> getAuthorsByBookISBN(@PathVariable("isbn") String isbn) {
//        try {
//            List<Author> authors = authorRepository.findAuthorsByBookISBN(isbn);
//            if (authors.isEmpty()) {
//                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//            }
//            return new ResponseEntity<>(authors, HttpStatus.OK);
//        } catch (Exception e) {
//            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//    }

    // Create a new author
    @PostMapping("/authors")
    public ResponseEntity<Author> createAuthor(@RequestBody Author author) {
        try {
            Author _author = authorRepository.save(new Author(author.getAuthorId(), author.getFirstName(), author.getLastName(), author.getDob(), author.getDod()));
            return new ResponseEntity<>(_author, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Update an existing author
    @PutMapping("/authors/{id}")
    public ResponseEntity<Author> updateAuthor(@PathVariable("id") Long id, @RequestBody Author author) {
        Optional<Author> authorData = authorRepository.findById(id);

        if (authorData.isPresent()) {
            Author _author = authorData.get();
            _author.setFirstName(author.getFirstName());
            _author.setLastName(author.getLastName());
            _author.setDob(author.getDob());
            _author.setDod(author.getDod());

            return new ResponseEntity<>(authorRepository.save(_author), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Delete an author by their ID
    @DeleteMapping("/authors/{id}")
    public ResponseEntity<HttpStatus> deleteAuthor(@PathVariable("id") Long id) {
        try {
            authorRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Delete all authors
    @DeleteMapping("/authors")
    public ResponseEntity<HttpStatus> deleteAllAuthors() {
        try {
            authorRepository.deleteAll();
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
