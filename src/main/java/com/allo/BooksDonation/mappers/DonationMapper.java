package com.allo.BooksDonation.mappers;

import com.allo.BooksDonation.dtos.DonationDTO;
import com.allo.BooksDonation.entities.Donation;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface DonationMapper extends BaseMapper<Donation, DonationDTO>{
}
