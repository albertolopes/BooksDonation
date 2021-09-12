package com.allo.BooksDonation.repositories;

import com.allo.BooksDonation.entities.Donation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface DonationRepository extends JpaRepository<Donation, Long> {

    @Query(
            nativeQuery = true,
            value = "SELECT * FROM book_info \n" +
                    "FULL OUTER JOIN authors ON (authors.id_authors = book_info.id_book_info)\n" +
                    "FULL OUTER JOIN categories ON (categories.id_categories = book_info.id_book_info) \n" +
                    "FULL OUTER JOIN book ON (book.id_book_info = book_info.id_book_info)\n" +
                    "FULL OUTER JOIN donation ON (donation.book_id = book.id_book)\n" +
                    "\n" +
                    "WHERE LOWER(book_info.title) ~ LOWER( :author ) \n" +
                    "OR LOWER(categories.categories) ~ LOWER( :categories ) \n" +
                    "OR LOWER(authors.authors) ~ LOWER( :title )" +
                    "ORDER BY (SELECT NULL)\n" +
                    "OFFSET :page ROWS FETCH NEXT :length ROWS ONLY"
    )
    List<Donation> findByBook(
            String author,
            String categories,
            String title,
            Long page,
            Long length
    );
}
