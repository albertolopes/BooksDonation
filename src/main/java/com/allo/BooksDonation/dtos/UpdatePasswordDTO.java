package com.allo.BooksDonation.dtos;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class UpdatePasswordDTO {

    private Long id;

    private String password;
}
