package com.allo.BooksDonation.dtos;

import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@EqualsAndHashCode
public class BookFeignDTO {

    private Long totalItems;

    private String kind;

    private List<BookDTO> items;
}
