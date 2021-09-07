package com.allo.BooksDonation.entities;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class Book implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_BOOK")
    private Long bookId;

    @Column(name = "SELF_LINK")
    private String selfLink;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ID_BOOK_INFO")
    private BookInfo volumeInfo;
}