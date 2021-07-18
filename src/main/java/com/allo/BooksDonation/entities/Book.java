package com.allo.BooksDonation.entities;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.UUID;

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

    @OneToOne(mappedBy="book", cascade = CascadeType.ALL)
    private BookInfo bookInfo;
}
