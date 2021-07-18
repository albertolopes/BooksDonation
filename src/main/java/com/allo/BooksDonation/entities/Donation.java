package com.allo.BooksDonation.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
public class Donation {

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID_DONATION")
    private Long donationId;

    @EmbeddedId
    private DonationPK info = new DonationPK();
}
