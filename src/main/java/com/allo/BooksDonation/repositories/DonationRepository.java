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
        value = "SELECT * FROM authors\n" +
                "INNER JOIN book_info ON (book_info.id_book_info = authors.id_authors)\n" +
                "INNER JOIN book ON (book.id_book_info = book_info.id_book_info)\n" +
                "INNER JOIN donation ON (donation.book_id = book.id_book)\n" +
                "WHERE LOWER(authors.authors) ~ LOWER( :author )"
    )
    List<Donation> findByAuthor(String author);

    @Query(
            nativeQuery = true,
            value = "SELECT * FROM categories \n" +
                    "INNER JOIN book_info ON (book_info.id_book_info = categories.id_categories)\n" +
                    "INNER JOIN book ON (book.id_book_info = book_info.id_book_info)\n" +
                    "INNER JOIN donation ON (donation.book_id = book.id_book)\n" +
                    "WHERE LOWER(categories.categories) ~ LOWER( :categories )"
    )
    List<Donation> findByCategories(String categories);

    @Query(
            nativeQuery = true,
            value = "SELECT * FROM book_info \n" +
                    "\n" +
                    "INNER JOIN authors ON (authors.id_authors = book_info.id_book_info)\n" +
                    "INNER JOIN categories ON (categories.id_categories = book_info.id_book_info)\n" +
                    "INNER JOIN book ON (book.id_book_info = book_info.id_book_info)\n" +
                    "INNER JOIN donation ON (donation.book_id = book.id_book)\n" +

                    "WHERE LOWER(book_info.title) ~ LOWER( :title )"
    )
    List<Donation> findByTitle(String title);
}
