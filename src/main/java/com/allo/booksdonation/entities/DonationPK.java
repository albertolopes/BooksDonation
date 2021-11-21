package com.allo.booksdonation.entities;

import lombok.*;

import javax.persistence.*;

@Embeddable

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
public class DonationPK {

    @ManyToOne
    @JoinColumn(name="ID_USER")
    private User user;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ID_BOOK")
    private Book book;
}
