package com.allo.booksdonation.controllers;

import com.allo.booksdonation.dtos.BookFeignDTO;
import com.allo.booksdonation.services.BookService;
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

    @GetMapping("/integration")
    @ApiOperation("Find a book for any description")
    public ResponseEntity<BookFeignDTO> searchBook(@RequestParam String description){
        return ResponseEntity.ok(service.searchBook(description));
    }

    @GetMapping("/categories")
    @ApiOperation("Find all categories")
    public ResponseEntity<List<String>> findAllCategories(){
        return ResponseEntity.ok(service.findAllCategories());
    }
}
