package com.allo.BooksDonation.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import java.util.Arrays;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@EqualsAndHashCode
public class BookFeign {

    private Long totalItems;

    private String kind;

    private List<Book> items;
}
