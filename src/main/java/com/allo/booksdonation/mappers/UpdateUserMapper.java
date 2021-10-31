package com.allo.booksdonation.mappers;

import com.allo.booksdonation.dtos.UpdateUserDTO;
import com.allo.booksdonation.entities.User;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UpdateUserMapper extends BaseMapper<User, UpdateUserDTO>{
}
