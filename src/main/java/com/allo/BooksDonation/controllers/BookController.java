package com.allo.BooksDonation.controllers;

import com.allo.BooksDonation.dtos.BookFeignDTO;
import com.allo.BooksDonation.services.BookService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/book")
@Api("Book")
public class BookController {

    @Autowired
    private BookService service;

    @GetMapping("/{description}")
    @ApiOperation("Find a book for any description")
    public ResponseEntity<BookFeignDTO> searchBook(@PathVariable String description){
        return ResponseEntity.ok(service.searchBook(description));
    }

    @GetMapping("/{categories}")
    @ApiOperation("Find all categories")
    public ResponseEntity<List<String>> findAllCategories(){
        return ResponseEntity.ok(service.findAllCategories());
    }
}
