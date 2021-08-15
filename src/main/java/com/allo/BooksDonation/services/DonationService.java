package com.allo.BooksDonation.services;

import com.allo.BooksDonation.dtos.DonationDTO;
import com.allo.BooksDonation.entities.Donation;
import com.allo.BooksDonation.entities.enums.DonateStatus;
import com.allo.BooksDonation.exceptions.ObjectNotFoundException;
import com.allo.BooksDonation.mappers.*;
import com.allo.BooksDonation.repositories.DonationRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@AllArgsConstructor
public class DonationService {

    private final DonationRepository repository;
    private final DonationMapper donationMapper;

    @Transactional
    public DonationDTO createDonation(DonationDTO dto) {
        Donation donation = donationMapper.toEntity(dto);
        donation.setStatus(DonateStatus.ACTIVE);

        return donationMapper.toDto(repository.save(donation));
    }

    public DonateStatus changeStatus(Long idDonation, String status) {
        Donation donation = repository.findById(idDonation).orElseThrow(() -> new ObjectNotFoundException("Donation not found."));
        donation.setStatus(DonateStatus.valueOf(status));
        repository.save(donation);
        return donation.getStatus();
    }

    public DonationDTO findADonarion(Long idDonation) {
        Donation donation = repository.findById(idDonation).orElseThrow(() -> new ObjectNotFoundException("Donation not found"));
        return donationMapper.toDto(donation);
    }

    public List<DonationDTO> findByAuthor(String author) {
        return donationMapper.toDto(repository.findByAuthor(author));
    }

    public List<DonationDTO> findByCategories(String categories) {
        return donationMapper.toDto(repository.findByCategories(categories));
    }

    public List<DonationDTO> findByTitle(String title) {
        return donationMapper.toDto(repository.findByTitle(title));
    }
}
