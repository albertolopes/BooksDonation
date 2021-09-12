package com.allo.BooksDonation.mappers;

import com.allo.BooksDonation.dtos.AddressDTO;
import com.allo.BooksDonation.entities.Address;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface AddressMapper extends BaseMapper<Address, AddressDTO>{
}
