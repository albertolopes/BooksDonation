package com.allo.BooksDonation.dtos;

import lombok.*;

import java.io.Serializable;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class UserDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;

    private String username;

    private String email;

    private String phone;
}
