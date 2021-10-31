package com.allo.booksdonation.entities;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Embeddable

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
public class DonationPK implements Serializable {
    private static final long serialVersionUID = 1L;

    @ManyToOne
    @JoinColumn(name="ID_USER")
    private User user;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ID_BOOK")
    private Book book;
}
