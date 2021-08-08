package com.allo.BooksDonation.controllers;

import com.allo.BooksDonation.dtos.CreateUserDTO;
import com.allo.BooksDonation.dtos.UpdatePasswordDTO;
import com.allo.BooksDonation.dtos.UpdateUserDTO;
import com.allo.BooksDonation.dtos.UserDTO;
import com.allo.BooksDonation.mappers.CreateUserMapper;
import com.allo.BooksDonation.mappers.UpdateUserMapper;
import com.allo.BooksDonation.mappers.UserMapper;
import com.allo.BooksDonation.services.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/user")
@Api("User")
@AllArgsConstructor
public class UserController {

    private final UserService userService;

    private final CreateUserMapper createMapper;

    private final UpdateUserMapper updateMapper;

    private final UserMapper mapper;

    @GetMapping
    @ApiOperation("Find an user by id")
    public ResponseEntity<UserDTO> findById(@RequestParam Long id){
        return ResponseEntity.ok(mapper.toDto(userService.findById(id)));
    }

    @PostMapping
    @ApiOperation("Create an user")
    public ResponseEntity<CreateUserDTO> createUser(@RequestBody CreateUserDTO dto){
        return ResponseEntity.ok(createMapper.toDto(userService.createUser(createMapper.toEntity(dto))));
    }

    @PutMapping
    @ApiOperation("Update an user")
    public ResponseEntity<UpdateUserDTO> updateUser(@RequestBody UpdateUserDTO dto){
        return ResponseEntity.ok(updateMapper.toDto(userService.updateUser(updateMapper.toEntity(dto))));
    }

    @PutMapping("/update-password")
    @ApiOperation("Update password")
    public ResponseEntity<String> updatePassword(@RequestBody UpdatePasswordDTO dto){
        return ResponseEntity.ok(userService.updatePassword(dto));
    }

}
