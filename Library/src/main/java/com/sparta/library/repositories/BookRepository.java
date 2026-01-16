package com.sparta.library.repositories;

import com.sparta.library.entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {
    List<Book> findByTitleContainingIgnoreCase(String title);

    @Query("""
    SELECT b
    FROM Book b
    WHERE LOWER(b.title) LIKE LOWER(CONCAT('%', :title, '%'))
""")
    List<Book> findByTitleContainingIgnoreCase_alt(@Param("title") String title);

}
