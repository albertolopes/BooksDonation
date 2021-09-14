package com.allo.BooksDonation.dtos;

import lombok.Data;

@Data
public class FilterBookDonationDTO {

    private String author;
    private String categories;
    private String title;
    private Long page;
    private Long length;
}
