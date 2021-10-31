package com.allo.booksdonation.dtos;

import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class UpdateUserDTO {

    private Long id;

    private String username;

    private String email;

    private String phone;
}
