package com.allo.BooksDonation.controllers;

import com.allo.BooksDonation.dtos.UserDTO;
import com.allo.BooksDonation.mappers.UserMapper;
import com.allo.BooksDonation.services.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/user")
@Api("User")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserMapper mapper;

    @GetMapping
    @ApiOperation("Find an user by id")
    public ResponseEntity<UserDTO> findById(@PathVariable Long id){
        return ResponseEntity.ok(mapper.toDto(userService.findById(id)));
    }

}
