package com.allo.booksdonation.dtos;

import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
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

    private Set<String> authors = new HashSet<>();

    private Set<String> categories = new HashSet<>();
}
