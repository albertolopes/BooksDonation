package com.allo.booksdonation.entities;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Builder
public class Book {

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