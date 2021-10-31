package com.allo.booksdonation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class BooksDonationApplication {

	public static void main(String[] args) {
		SpringApplication.run(BooksDonationApplication.class, args);
	}

}
