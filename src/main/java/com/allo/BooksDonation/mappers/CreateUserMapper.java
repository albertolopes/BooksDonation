package com.allo.BooksDonation.mappers;

import com.allo.BooksDonation.dtos.CreateUserDTO;
import com.allo.BooksDonation.entities.User;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CreateUserMapper extends BaseMapper<User, CreateUserDTO>{
}
