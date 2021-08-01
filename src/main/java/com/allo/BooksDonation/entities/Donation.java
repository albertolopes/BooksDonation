package com.allo.BooksDonation.entities;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
public class Donation implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_DONATION")
    private Long id;

    @ManyToOne
    @JoinColumn(name="ID_USER")
    private User user;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "bookId")
    private Book book;
}
