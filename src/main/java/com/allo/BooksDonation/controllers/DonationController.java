package com.allo.BooksDonation.controllers;

import com.allo.BooksDonation.dtos.DonationDTO;
import com.allo.BooksDonation.entities.Donation;
import com.allo.BooksDonation.entities.enums.DonateStatus;
import com.allo.BooksDonation.services.DonationService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/donation")
@Api("Donation")
@AllArgsConstructor
public class DonationController {

    private final DonationService service;

    @PostMapping
    @ApiOperation("Create a new donation")
    public ResponseEntity<DonationDTO> createDonation(@RequestBody DonationDTO donation){
        return ResponseEntity.ok(service.createDonation(donation));
    }

    @PutMapping("/{idDonation}/{status}")
    @ApiOperation("Change donation status")
    public ResponseEntity<DonateStatus> changeStatus(@PathVariable Long idDonation, @PathVariable String status){
        return ResponseEntity.ok(service.changeStatus(idDonation, status));
    }

    @GetMapping("/{idDonation}")
    @ApiOperation("Find a donation")
    public ResponseEntity<DonationDTO> findADonation(@PathVariable Long idDonation){
        return ResponseEntity.ok(service.findADonarion(idDonation));
    }

    @GetMapping("/author/{author}")
    @ApiOperation("Find a donation by author")
    public ResponseEntity<List<DonationDTO>> findByAuthor(@PathVariable String author){
        return ResponseEntity.ok(service.findByAuthor(author));
    }

    @GetMapping("/categories/{categories}")
    @ApiOperation("Find a donation by categories")
    public ResponseEntity<List<DonationDTO>> findByCategories(@PathVariable String categories){
        return ResponseEntity.ok(service.findByCategories(categories));
    }

    @GetMapping("/title/{title}")
    @ApiOperation("Find a donation by categories")
    public ResponseEntity<List<DonationDTO>> findByTitle(@PathVariable String title){
        return ResponseEntity.ok(service.findByTitle(title));
    }
}