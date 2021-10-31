package com.allo.booksdonation.entities;

import lombok.*;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Getter
@Setter
@Builder
public class ImageLinks {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_IMAGE_LINKS")
    private Long id;

    @Column(name = "SMALL_THUMBNAIL")
    private String smallThumbnail;

    @Column(name = "THUMBNAIL")
    private String thumbnail;
}
