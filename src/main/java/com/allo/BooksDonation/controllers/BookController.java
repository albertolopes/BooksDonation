package com.allo.BooksDonation.controllers;

import com.allo.BooksDonation.entities.BookFeign;
import com.allo.BooksDonation.services.BookService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/book")
@Api("Book")
public class BookController {

    @Autowired
    private BookService service;

    @GetMapping("/{description}")
    @ApiOperation("Find a book for any description")
    public ResponseEntity<BookFeign> searchBook(@PathVariable String description){
        return ResponseEntity.ok(service.searchBook(description));
    }
}
