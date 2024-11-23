package com.example.library_cs4750.controller;

import com.example.library_cs4750.model.SerialPublication;
import com.example.library_cs4750.repository.SerialPublicationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class SerialPublicationController {

    @Autowired
    private SerialPublicationRepository serialPublicationRepository;

    // Get all serial publications or filter by title
    @GetMapping("/serial-publications")
    public ResponseEntity<List<SerialPublication>> getAllSerialPublications(@RequestParam(required = false) String title) {
        try {
            List<SerialPublication> serialPublications;

            if (title == null) {
                serialPublications = serialPublicationRepository.findAll();
            } else {
                serialPublications = serialPublicationRepository.findByTitleContainingIgnoreCase(title);
            }

            if (serialPublications.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(serialPublications, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Get a serial publication by ISSN
    @GetMapping("/serial-publications/{issn}")
    public ResponseEntity<SerialPublication> getSerialPublicationByIssn(@PathVariable("issn") String issn) {
        Optional<SerialPublication> serialPublicationData = serialPublicationRepository.findByIssn(issn);

        return serialPublicationData.map(serialPublication -> new ResponseEntity<>(serialPublication, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // Create a new serial publication
    @PostMapping("/serial-publications")
    public ResponseEntity<SerialPublication> createSerialPublication(@RequestBody SerialPublication serialPublication) {
        try {
            SerialPublication _serialPublication = serialPublicationRepository.save(serialPublication);
            return new ResponseEntity<>(_serialPublication, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Update an existing serial publication
    @PutMapping("/serial-publications/{issn}")
    public ResponseEntity<SerialPublication> updateSerialPublication(@PathVariable("issn") String issn, @RequestBody SerialPublication serialPublication) {
        Optional<SerialPublication> serialPublicationData = serialPublicationRepository.findByIssn(issn);

        if (serialPublicationData.isPresent()) {
            SerialPublication _serialPublication = serialPublicationData.get();
            _serialPublication.setTitle(serialPublication.getTitle());
            _serialPublication.setPublisher(serialPublication.getPublisher());
            _serialPublication.setEditor(serialPublication.getEditor());
            _serialPublication.setCategory(serialPublication.getCategory());
            _serialPublication.setIllustratorName(serialPublication.getIllustratorName());
            _serialPublication.setSeriesTitle(serialPublication.getSeriesTitle());

            return new ResponseEntity<>(serialPublicationRepository.save(_serialPublication), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Delete a serial publication by ISSN
    @DeleteMapping("/serial-publications/{issn}")
    public ResponseEntity<HttpStatus> deleteSerialPublication(@PathVariable("issn") String issn) {
        try {
            serialPublicationRepository.deleteById(issn);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Delete all serial publications
    @DeleteMapping("/serial-publications")
    public ResponseEntity<HttpStatus> deleteAllSerialPublications() {
        try {
            serialPublicationRepository.deleteAll();
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
