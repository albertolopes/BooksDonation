package com.allo.BooksDonation.entities;

import lombok.*;
import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class Book {

    @Id
    @Column(name = "UUID_BOOK")
    private String id;

    @Column(name = "SELF_LINK")
    private String selfLink;

    @OneToOne(mappedBy="book")
    private BookInfo volumeInfo;
}
