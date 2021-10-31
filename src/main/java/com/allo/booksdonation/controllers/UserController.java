package com.allo.booksdonation.controllers;

import com.allo.booksdonation.dtos.CreateUserDTO;
import com.allo.booksdonation.dtos.UpdatePasswordDTO;
import com.allo.booksdonation.dtos.UpdateUserDTO;
import com.allo.booksdonation.dtos.UserDTO;
import com.allo.booksdonation.mappers.CreateUserMapper;
import com.allo.booksdonation.mappers.UpdateUserMapper;
import com.allo.booksdonation.mappers.UserMapper;
import com.allo.booksdonation.services.UserService;
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
