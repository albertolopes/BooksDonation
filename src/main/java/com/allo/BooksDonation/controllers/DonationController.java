package com.allo.BooksDonation.controllers;

import com.allo.BooksDonation.dtos.DonationDTO;
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

    @GetMapping("/filter")
    @ApiOperation(
            value = "Find a donation by author, category or title.",
            notes= "You can use the variables page and length for pagination. " +
                    "The variable page will be used to indicate the page, " +
                    "and the variable length to indicate how much results to return in each page"
    )
    public ResponseEntity<List<DonationDTO>> findByBook(
            @RequestParam(required=false) String author,
            @RequestParam(required=false) String categories,
            @RequestParam(required=false) String title,
            @RequestParam Long page,
            @RequestParam Long length
    ){
        return ResponseEntity.ok(service.findByBook(author, categories , title, page, length));
    }
}