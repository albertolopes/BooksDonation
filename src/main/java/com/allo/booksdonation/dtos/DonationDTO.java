package com.allo.booksdonation.dtos;

import com.allo.booksdonation.entities.enums.DonateStatus;
import lombok.*;
import java.time.Instant;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
public class DonationDTO {

    private Long id;

    private Instant lastDateUpdated;

    private UserDTO user;

    private BookDTO book;

    private DonateStatus status;
}
