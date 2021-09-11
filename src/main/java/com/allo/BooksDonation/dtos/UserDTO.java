package com.allo.BooksDonation.dtos;

import com.allo.BooksDonation.entities.enums.Roles;
import lombok.*;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

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

    private String password;

    private Set<Roles> roles = new HashSet<>();
}
