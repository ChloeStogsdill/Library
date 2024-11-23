package com.example.library_cs4750.controller;

import com.example.library_cs4750.model.Library;
import com.example.library_cs4750.repository.LibraryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class LibraryController {

    @Autowired
    private LibraryRepository libraryRepository;

    // Get all libraries or filter by name
    @GetMapping("/libraries")
    public ResponseEntity<List<Library>> getAllLibraries(@RequestParam(required = false) String name) {
        try {
            List<Library> libraries;

            if (name == null) {
                libraries = libraryRepository.findAll();
            } else {
                libraries = libraryRepository.findByNameContainingIgnoreCase(name);
            }

            if (libraries.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(libraries, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Get a library by its ID
    @GetMapping("/libraries/{id}")
    public ResponseEntity<Library> getLibraryById(@PathVariable("id") int id) {
        Optional<Library> libraryData = libraryRepository.findById(id);

        return libraryData.map(library -> new ResponseEntity<>(library, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // Get a library by its name
    @GetMapping("/libraries/name/{name}")
    public ResponseEntity<Library> getLibraryByName(@PathVariable("name") String name) {
        Optional<Library> libraryData = libraryRepository.findByName(name);

        return libraryData.map(library -> new ResponseEntity<>(library, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // Create a new library
    @PostMapping("/libraries")
    public ResponseEntity<Library> createLibrary(@RequestBody Library library) {
        try {
            Library _library = libraryRepository.save(new Library(library.getLibraryId(), library.getName()));
            return new ResponseEntity<>(_library, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Update an existing library
    @PutMapping("/libraries/{id}")
    public ResponseEntity<Library> updateLibrary(@PathVariable("id") int id, @RequestBody Library library) {
        Optional<Library> libraryData = libraryRepository.findById(id);

        if (libraryData.isPresent()) {
            Library _library = libraryData.get();
            _library.setName(library.getName());

            return new ResponseEntity<>(libraryRepository.save(_library), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Delete a library by its ID
    @DeleteMapping("/libraries/{id}")
    public ResponseEntity<HttpStatus> deleteLibrary(@PathVariable("id") int id) {
        try {
            libraryRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Delete all libraries
    @DeleteMapping("/libraries")
    public ResponseEntity<HttpStatus> deleteAllLibraries() {
        try {
            libraryRepository.deleteAll();
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
