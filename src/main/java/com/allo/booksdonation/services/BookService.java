package com.allo.booksdonation.services;

import com.allo.booksdonation.clients.BookClient;
import com.allo.booksdonation.dtos.BookFeignDTO;
import com.allo.booksdonation.entities.Book;

import com.allo.booksdonation.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
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
