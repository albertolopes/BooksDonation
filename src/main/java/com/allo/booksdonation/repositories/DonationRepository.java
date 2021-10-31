package com.allo.booksdonation.repositories;

import com.allo.booksdonation.entities.Donation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface DonationRepository extends JpaRepository<Donation, Long>,
        JpaSpecificationExecutor<Donation> {
}
