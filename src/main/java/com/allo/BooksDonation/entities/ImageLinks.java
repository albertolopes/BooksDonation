package com.allo.BooksDonation.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
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

    @Column(name = "SMALL_THUMBNAIL")
    private String smallThumbnail;

    @Column(name = "THUMBNAIL")
    private String thumbnail;
}
