package com.allo.BooksDonation.services;

import com.allo.BooksDonation.client.BookClient;
import com.allo.BooksDonation.entities.Book;
import com.allo.BooksDonation.entities.BookFeign;

import com.allo.BooksDonation.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class BookService {

    @Autowired
    private BookClient bookClient;

    @Autowired
    private BookRepository bookRepository;

    @Value("${default.google.book.apikey}")
    private String apikey;

    public BookFeign searchBook(String description){return bookClient.getBookByDescription(description, apikey);}

    public Book saveBook(Book book){
        return bookRepository.save(book);
    }
}
