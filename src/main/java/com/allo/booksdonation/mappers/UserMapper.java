package com.allo.booksdonation.mappers;

import com.allo.booksdonation.dtos.UserDTO;
import com.allo.booksdonation.entities.User;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UserMapper extends BaseMapper<User, UserDTO>{
}
