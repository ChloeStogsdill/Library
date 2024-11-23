package com.example.library_cs4750.repository;

import com.example.library_cs4750.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, String> {
    List<Book> findByTitleContaining(String title);
//    @Query("SELECT b FROM Book b JOIN AuthorToBook ab ON b.isbn = ab.book.isbn WHERE ab.author.authorId = :authorId")
//    List<Book> findBooksByAuthorId(Long authorId);
}
