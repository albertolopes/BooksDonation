package com.allo.BooksDonation.dtos;

import lombok.*;
import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
public class DonationDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;

    private UserDTO user;

    private BookDTO book;
}