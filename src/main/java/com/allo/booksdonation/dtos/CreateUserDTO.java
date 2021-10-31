package com.allo.booksdonation.dtos;

import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class CreateUserDTO {

    private Long id;

    private String username;

    private String email;

    private String password;

    private String phone;
}
