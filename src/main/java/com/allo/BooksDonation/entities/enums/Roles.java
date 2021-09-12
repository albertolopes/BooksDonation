package com.allo.BooksDonation.entities.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum Roles {

    ADMIN(0,"ADMIN"),
    USER(1, "USER");

    private int cod;
    private String description;
}
