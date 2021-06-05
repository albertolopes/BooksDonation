package com.allo.BooksDonation.client;

import com.allo.BooksDonation.entities.BookFeign;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

//class ApiKey{
//    @Value("${default.google.book.apikey}")
//    public static String apikey;
//}

@FeignClient(name = "addressClient", url = "https://www.googleapis.com/")
public interface BookClient {

//    String apikey = ApiKey.apikey;

    @GetMapping("books/v1/volumes?q={description}&projection=lite&key={apiKey}")
    BookFeign getBookByDescription(
            @PathVariable String description,
            @PathVariable String apiKey
    );
}
