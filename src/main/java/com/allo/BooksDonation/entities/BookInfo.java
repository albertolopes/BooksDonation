package com.allo.BooksDonation.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.*;
import org.hibernate.annotations.CollectionId;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
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
    @Column(name = "ID_BOOK_INFO")
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

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ID_IMAGE_LINKS")
    private ImageLinks imageLinks;


//    @ElementCollection//(fetch = FetchType.EAGER)
//    //@CollectionTable(name = "AUTHORS", joinColumns = @JoinColumn(name = "userId"))
//    //@JoinTable(name = "AUTHORS")
////    @MapKey(name = "id")
//    @JoinTable(name="AUTHORS",joinColumns=@JoinColumn(name="ID_BOOK"))
//    @GenericGenerator(name="hilo-generator",strategy="hilo")
//    @CollectionId(columns={@Column(name="ID")},generator="hilo-generator",type=@Type(type="long"))
//    private List<String> authors;

//    @ElementCollection
//    @CollectionTable(name = "AUTHORS", joinColumns = @JoinColumn(name = "userId"))
//    @Column(name = "AUTHORS")
//    private List<String> authors;

//    @ElementCollection(fetch = FetchType.EAGER)
//    @JoinTable(name = "AUTHORS")
//    @MapKey(name = "id_authors")
    @ElementCollection
    @CollectionTable(name = "AUTHORS", joinColumns = @JoinColumn(name = "ID_AUTHORS"))
    //@Column(name = "AUTHORS")
    //@JoinColumn(name = "ID_AUTHORS")
    private List<String> authors = new ArrayList<>();
}