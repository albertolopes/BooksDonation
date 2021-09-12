package com.allo.BooksDonation.dtos;

import lombok.*;

import java.io.Serializable;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class AddressDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long Id;

    private String cep;

    private String logradouro;

    private String complemento;

    private String bairro;

    private String localidade;

    private String uf;

    private UserDTO user;
}
