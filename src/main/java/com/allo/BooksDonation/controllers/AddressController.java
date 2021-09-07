package com.allo.BooksDonation.controllers;

import com.allo.BooksDonation.dtos.AddressDTO;
import com.allo.BooksDonation.services.AddressService;
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

    @GetMapping("/{cep}")
    @ApiOperation("Find address by cep")
    public ResponseEntity<AddressDTO> findAddressByCep(@PathVariable Long cep){
        return ResponseEntity.ok(service.getAddressByCep(cep));
    }

}
