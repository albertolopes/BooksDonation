package com.allo.BooksDonation.services;

import com.allo.BooksDonation.dtos.DonationDTO;
import com.allo.BooksDonation.mappers.*;
import com.allo.BooksDonation.repositories.DonationRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@AllArgsConstructor
public class DonationService {

    private final BookService bookService;
    private final DonationRepository repository;
    private final DonationMapper donationMapper;
    private final UserMapper userMapper;

    @Transactional
    public DonationDTO createDonation(DonationDTO dto) {
        return donationMapper.toDto(repository.save(donationMapper.toEntity(dto)));
    }
}
