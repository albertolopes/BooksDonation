package com.allo.BooksDonation.client;

import com.allo.BooksDonation.dtos.AddressDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "addressClient", url = "https://viacep.com.br/")
public interface AddressClient {

    @GetMapping("ws/{cep}/json/")
    AddressDTO getAddressByCep(
            @PathVariable Long cep
    );
}
