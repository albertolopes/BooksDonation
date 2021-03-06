package com.allo.booksdonation.controllers;

import com.allo.booksdonation.dtos.ContentsDonationsDTO;
import com.allo.booksdonation.dtos.DonationDTO;
import com.allo.booksdonation.dtos.FilterDonationsDTO;
import com.allo.booksdonation.entities.enums.DonateStatus;
import com.allo.booksdonation.services.DonationService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @PutMapping
    @ApiOperation("Update a donation")
    public ResponseEntity<DonationDTO> updateDonation(@RequestBody DonationDTO donation){
        return ResponseEntity.ok(service.updateDonation(donation));
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
    public ResponseEntity<Page<ContentsDonationsDTO>> findByBook(
            @RequestParam(required=false) String author,
            @RequestParam(required=false) String categories,
            @RequestParam(required=false) String title,
            @RequestParam(value = "page", defaultValue = "0") Integer page,
            @RequestParam(value = "linesPerPage", defaultValue = "10") Integer linesPerPage,
            @RequestParam(value = "orderBy", defaultValue = "id") String orderBy,
            @ApiParam(allowableValues = "ASC, DESC")
            @RequestParam(value = "direction", defaultValue = "ASC") String direction
    ){
        return ResponseEntity.ok(service.findByBook(
                new FilterDonationsDTO(
                        author,
                        categories,
                        title
                ),
                PageRequest.of(page, linesPerPage, Sort.Direction.valueOf(direction.toUpperCase()), orderBy)
        ));
    }
}