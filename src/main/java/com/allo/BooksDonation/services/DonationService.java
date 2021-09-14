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
import java.time.Instant;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;

@Service
@AllArgsConstructor
public class DonationService {

    private final DonationRepository repository;
    private final DonationMapper donationMapper;

    @Transactional
    public DonationDTO createDonation(DonationDTO dto) {
        Donation donation = donationMapper.toEntity(dto);
        donation.setLastDateUpdated(Instant.now());

        donation.setStatus(DonateStatus.ACTIVE);
        donation.setId(null);

        return donationMapper.toDto(repository.save(donation));
    }

    @Transactional
    public DonationDTO updateDonation(DonationDTO dto) {
        Donation donation = donationMapper.toEntity(dto);
        donation.setLastDateUpdated(Instant.now());

        donation.setStatus(DonateStatus.ACTIVE);

        return donationMapper.toDto(repository.save(donation));

    }

    public DonateStatus changeStatus(Long idDonation, String status) {
        Donation donation = repository.findById(idDonation).orElseThrow(() -> new ObjectNotFoundException("Donation not found."));

        UserSecurityService.verificaUsuarioLogado(donation.getUser().getId());

        donation.setStatus(DonateStatus.valueOf(status));
        repository.save(donation);
        return donation.getStatus();
    }

    public DonationDTO findADonarion(Long idDonation) {
        Donation donation = repository.findById(idDonation).orElseThrow(() -> new ObjectNotFoundException("Donation not found"));
        return donationMapper.toDto(donation);
    }

    public List<DonationDTO> findByBook(String author, String categories, String title, Long page, Long length) {

        return donationMapper.toDto(repository.findByBook(
                !isNullOrEmpty(author)? author : "",
                !isNullOrEmpty(categories) ? categories : "",
                !isNullOrEmpty(title) ? title : "",
                page!= null ? page : 0,
                length != null ? length : 0
        ));
    }
}
