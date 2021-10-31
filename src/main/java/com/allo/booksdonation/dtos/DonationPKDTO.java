package com.allo.booksdonation.dtos;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
public class DonationPKDTO {

    private UserDTO user;

    private BookDTO book;
}
