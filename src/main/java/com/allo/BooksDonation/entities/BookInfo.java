package com.allo.BooksDonation.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class BookInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_BOOK_USER")
    private Long id;

    @Column(name = "TITLE")
    private String title;

    @Column(name = "PUBLISHER")
    private String publisher;

    @Column(name = "PUBLISHER_DATE")
    private String publishedDate;

    @Column(name = "DESCRIPTION")
    private String description;

    @Column(name = "PREVIEW_LINK")
    private String previewLink;

    @Column(name = "INFO_LINK")
    private String infoLink;

    @Column(name = "CANONICAL_VOLUME_LINK")
    private String canonicalVolumeLink;

    @Column(name = "TEXT_SNIPPET")
    private String textSnippet;

    @OneToOne(mappedBy="book", cascade = CascadeType.ALL)
    private ImageLinks imageLinks;

    @JsonIgnore
    @OneToOne
    @JoinColumn(name = "bookId")
    private Book book;

    @ElementCollection(fetch = FetchType.EAGER)
    @JoinTable(name = "AUTHORS")
    @MapKey(name = "id_authors")
    private List<String> authors;
}
