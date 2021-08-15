package com.allo.BooksDonation.repositories;

import com.allo.BooksDonation.entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

    @Query(
            nativeQuery = true,
            value = "SELECT DISTINCT upper( categories ) FROM categories"
    )
    List<String> findAllCategories();
}
