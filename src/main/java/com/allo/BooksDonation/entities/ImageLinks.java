package com.allo.BooksDonation.entities;

import lombok.*;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Getter
@Setter
public class ImageLinks {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_IMAGE_LINKS")
    private Long id;

    private String smallThumbnail;

    private String thumbnail;

    @OneToOne
    @JoinColumn(name = "book_id")
    private Book book;
}
