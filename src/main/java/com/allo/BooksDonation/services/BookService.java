package com.allo.BooksDonation.services;

import com.allo.BooksDonation.clients.BookClient;
import com.allo.BooksDonation.dtos.BookFeignDTO;
import com.allo.BooksDonation.entities.Book;

import com.allo.BooksDonation.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    @Autowired
    private BookClient bookClient;

    @Autowired
    private BookRepository bookRepository;

    public BookFeignDTO searchBook(String description){return bookClient.getBookByDescription(description);}

    public Book saveBook(Book book){
        return bookRepository.save(book);
    }

    public List<String> findAllCategories() {
        return bookRepository.findAllCategories();
    }
}
