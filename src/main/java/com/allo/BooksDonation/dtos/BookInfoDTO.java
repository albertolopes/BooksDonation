package com.allo.BooksDonation.dtos;

import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
//@EqualsAndHashCode
public class BookInfoDTO {

    private Long id;

    private String title;

    private String publisher;

    private String publishedDate;

    private String description;

    private String previewLink;

    private String infoLink;

    private String canonicalVolumeLink;

    private String textSnippet;

    private ImageLinksDTO imageLinks;

    //private BookDTO book;

    private List<String> authors = new ArrayList<>();
}
