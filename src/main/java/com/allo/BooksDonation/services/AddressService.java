package com.allo.BooksDonation.services;

import com.allo.BooksDonation.client.AddressClient;
import com.allo.BooksDonation.dtos.AddressDTO;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AddressService {

    private final AddressClient client;

    public AddressDTO getAddressByCep(Long cep){
        return client.getAddressByCep(cep);
    }
}
