package com.allo.booksdonation.dtos;

import lombok.*;

@Builder
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class FilterDonationsDTO {

    private String author;

    private String categories;

    private String title;
}
