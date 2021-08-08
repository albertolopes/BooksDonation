package com.allo.BooksDonation.repositories;

import com.allo.BooksDonation.entities.Donation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface DonationRepository extends JpaRepository<Donation, Long> {
}
