package com.allo.booksdonation.services;

import com.allo.booksdonation.clients.AddressClient;
import com.allo.booksdonation.dtos.AddressDTO;
import com.allo.booksdonation.entities.Address;
import com.allo.booksdonation.exceptions.ObjectNotFoundException;
import com.allo.booksdonation.repositories.AddressRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AddressService {

    private final AddressClient addressClient;

    private final AddressRepository addressRepository;

    public AddressDTO getAddressByCep(Long cep){
        return addressClient.getAddressByCep(cep);
    }

    public Address findAddress(Long id) {
        return addressRepository.findById(id).orElseThrow(()-> new ObjectNotFoundException("Address was not found"));
    }

    public Address createOrUpdateAddress(Address address) {
        UserSecurityService.verificaUsuarioLogado(address.getUser().getId());
        return addressRepository.save(address);
    }

    public void deleteAddress(Address address) {
        UserSecurityService.verificaUsuarioLogado(address.getUser().getId());
        addressRepository.deleteById(address.getId());
    }
}
