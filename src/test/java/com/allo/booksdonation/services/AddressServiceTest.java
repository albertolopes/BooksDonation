package com.allo.booksdonation.services;

import com.allo.booksdonation.clients.AddressClient;
import com.allo.booksdonation.dtos.AddressDTO;
import com.allo.booksdonation.entities.Address;
import com.allo.booksdonation.entities.User;
import com.allo.booksdonation.repositories.AddressRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Optional;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class AddressServiceTest {

    private static Long CEP = 69313718L;

    @SpyBean
    private AddressService service;

    @MockBean
    private AddressRepository addressRepository;

    @MockBean
    private AddressClient addressClient;

    @Test
    @DisplayName("Must find an address by cep")
    public void getAddressByCep(){
        Mockito.when(addressClient.getAddressByCep(Mockito.anyLong())).thenReturn(new AddressDTO());
        AddressDTO response = service.getAddressByCep(CEP);
        Assertions.assertNotNull(response);
    }

    @Test
    @DisplayName("Must find an address")
    public void findAddress(){
        Optional address = Optional.of(new Address());
        Mockito.when(addressRepository.findById(Mockito.anyLong())).thenReturn(address);
        Address response = service.findAddress(1L);
        Assertions.assertNotNull(response);
    }

    @Test
    @WithMockUser(username = "livros", roles = { "ADMIN" })
    @DisplayName("Must create an Address")
    public void createAddress(){
        Address address = createAnAddress();
        Mockito.when(addressRepository.save(Mockito.any(Address.class))).thenReturn(address);
        Address response = service.createOrUpdateAddress(address);
        Assertions.assertNotNull(response);
    }

    public Address createAnAddress(){
        User user = new User();
        user.setId(1L);

        Address address = new Address();
        address.setCep("69911206");
        address.setLogradouro("Rua Itaipú");
        address.setComplemento("");
        address.setBairro("Palheiral");
        address.setLocalidade("Rio Branco");
        address.setUf("AC");
        address.setUser(user);

        return address;
    }


}
