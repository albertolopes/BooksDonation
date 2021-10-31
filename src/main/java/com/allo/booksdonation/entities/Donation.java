package com.allo.booksdonation.entities;

import com.allo.booksdonation.entities.enums.DonateStatus;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import javax.persistence.*;
import java.time.Instant;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@Builder
public class Donation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_DONATION")
    private Long id;

    @Column(name = "STATUS")
    private DonateStatus status;

    @JsonFormat(
        shape = JsonFormat.Shape.STRING,
        pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'",
        timezone = "GMT"
    )
    @Column(name ="CREATE_DATE")
    private Instant lastDateUpdated;

    @ManyToOne
    @JoinColumn(name="ID_USER")
    private User user;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "bookId")
    private Book book;
}
