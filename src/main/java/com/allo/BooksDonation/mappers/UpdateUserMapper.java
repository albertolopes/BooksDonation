package com.allo.BooksDonation.mappers;

import com.allo.BooksDonation.dtos.UpdateUserDTO;
import com.allo.BooksDonation.entities.User;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UpdateUserMapper extends BaseMapper<User, UpdateUserDTO>{
}
