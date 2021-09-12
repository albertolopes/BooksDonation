package com.allo.BooksDonation.services;

import com.allo.BooksDonation.clients.AddressClient;
import com.allo.BooksDonation.dtos.AddressDTO;
import com.allo.BooksDonation.entities.Address;
import com.allo.BooksDonation.exceptions.ObjectNotFoundException;
import com.allo.BooksDonation.repositories.AddressRepository;
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

    public Address createAddress(Address address) {
        UserSecurityService.verificaUsuarioLogado(address.getUser().getId());
        return addressRepository.save(address);
    }

    public Address updateAddress(Address address) {
        UserSecurityService.verificaUsuarioLogado(address.getUser().getId());
        return addressRepository.save(address);
    }

    public void deleteAddress(Address address) {
        UserSecurityService.verificaUsuarioLogado(address.getUser().getId());
        addressRepository.deleteById(address.getId());
    }
}
