package com.allo.booksdonation.clients;

import com.allo.booksdonation.dtos.BookFeignDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "bookClient", url = "https://www.googleapis.com/")
public interface BookClient {

    @GetMapping("books/v1/volumes?q={description}")
    BookFeignDTO getBookByDescription(
            @PathVariable String description
    );
}
