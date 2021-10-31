package com.allo.booksdonation.mappers;

import com.allo.booksdonation.dtos.DonationDTO;
import com.allo.booksdonation.entities.Donation;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface DonationMapper extends BaseMapper<Donation, DonationDTO>{
}
