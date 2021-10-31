package com.allo.booksdonation.mappers;

import com.allo.booksdonation.dtos.AddressDTO;
import com.allo.booksdonation.entities.Address;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface AddressMapper extends BaseMapper<Address, AddressDTO>{
}
