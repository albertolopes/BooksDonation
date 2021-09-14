package com.allo.BooksDonation.dtos;

import com.allo.BooksDonation.entities.enums.DonateStatus;
import lombok.*;
import java.io.Serializable;
import java.time.Instant;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
public class DonationDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;

    private Instant date;

    private UserDTO user;

    private BookDTO book;

    private DonateStatus status;
}
