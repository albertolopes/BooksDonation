package com.allo.booksdonation.dtos;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
//@EqualsAndHashCode
public class ImageLinksDTO {

    private Long id;

    private String smallThumbnail;

    private String thumbnail;

    //private Book book;
}
