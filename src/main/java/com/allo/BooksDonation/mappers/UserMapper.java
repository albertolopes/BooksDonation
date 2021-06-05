package com.allo.BooksDonation.mappers;

import com.allo.BooksDonation.dtos.UserDTO;
import com.allo.BooksDonation.entities.User;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UserMapper extends BaseMapper<User, UserDTO>{
}
