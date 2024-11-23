package com.example.library_cs4750.repository;

import com.example.library_cs4750.model.SerialPublication;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface SerialPublicationRepository extends JpaRepository<SerialPublication, String> {

    // Find serial publications by title (case-insensitive)
    List<SerialPublication> findByTitleContainingIgnoreCase(String title);

    // Find a serial publication by ISSN
    Optional<SerialPublication> findByIssn(String issn);
}
