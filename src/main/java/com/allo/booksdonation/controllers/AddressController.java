package com.allo.booksdonation.controllers;

import com.allo.booksdonation.dtos.AddressDTO;
import com.allo.booksdonation.mappers.AddressMapper;
import com.allo.booksdonation.services.AddressService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/address")
@Api("Address")
@AllArgsConstructor
public class AddressController {

    private final AddressService service;

    private final AddressMapper mapper;

    @GetMapping("/integration/{cep}")
    @ApiOperation("Find address by cep")
    public ResponseEntity<AddressDTO> findAddressByCep(@PathVariable Long cep){
        return ResponseEntity.ok(service.getAddressByCep(cep));
    }

    @GetMapping("/{id}")
    @ApiOperation("Find user's address")
    public ResponseEntity<AddressDTO> findAddress(@PathVariable Long id){
        return ResponseEntity.ok(mapper.toDto(service.findAddress(id)));
    }

    @PostMapping
    @ApiOperation("Create a new address")
    public ResponseEntity<AddressDTO> createAddress(@RequestBody AddressDTO dto){
        return ResponseEntity.ok(mapper.toDto(service.createAddress(mapper.toEntity(dto))));
    }

    @PutMapping
    @ApiOperation("Update an address")
    public ResponseEntity<AddressDTO> updateAddress(@RequestBody AddressDTO dto){
        return ResponseEntity.ok(mapper.toDto(service.updateAddress(mapper.toEntity(dto))));
    }

    @DeleteMapping
    @ApiOperation("Update an address")
    public ResponseEntity<Void> deleteAddress(@RequestBody AddressDTO dto){
         service.deleteAddress(mapper.toEntity(dto));
         return ResponseEntity.noContent().build();
    }

}
