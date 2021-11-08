package com.allo.booksdonation.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ContentsDonationsDTO {

    private Long bookId;

    private Long bookInfoId;

    private String title;

    private String publisher;

    private String publishedDate;

    private String description;

    private String previewLink;

    private String infoLink;

    private String canonicalVolumeLink;

    private String textSnippet;

    private String authors;

    private String categories;
}
