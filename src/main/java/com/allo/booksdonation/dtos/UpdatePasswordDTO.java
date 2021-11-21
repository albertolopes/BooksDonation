package com.allo.booksdonation.dtos;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class UpdatePasswordDTO {

    private Long id;

    private String currentPassword;

    private String newPassword;
}
