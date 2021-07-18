package com.allo.BooksDonation.services;

import com.allo.BooksDonation.entities.Donation;
import com.allo.BooksDonation.repositories.DonationRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@AllArgsConstructor
public class DonationService {

    private final DonationRepository repository;

    private final BookService bookService;

    @Transactional
    public Donation createDonation(Donation donation) {
        bookService.saveBook(donation.getInfo().getBook());
        return repository.save(donation);
    }
}
