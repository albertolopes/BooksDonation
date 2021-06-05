package com.allo.BooksDonation.services;

import com.allo.BooksDonation.client.BookClient;
import com.allo.BooksDonation.entities.BookFeign;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class BookService {

    @Autowired
    private BookClient bookClient;

    @Value("${default.google.book.apikey}")
    private String apikey;

    public BookFeign searchBook(String description){
        return bookClient.getBookByDescription(description, apikey);
    }
}
