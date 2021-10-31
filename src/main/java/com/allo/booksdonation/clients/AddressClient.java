package com.allo.booksdonation.clients;

import com.allo.booksdonation.dtos.AddressDTO;
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
