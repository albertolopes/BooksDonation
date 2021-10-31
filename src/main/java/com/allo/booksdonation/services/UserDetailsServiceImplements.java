package com.allo.booksdonation.services;

import com.allo.booksdonation.entities.User;
import com.allo.booksdonation.exceptions.UsernameNotFoundException;
import com.allo.booksdonation.repositories.UserRepository;
import com.allo.booksdonation.security.UserSecurity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImplements implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username){
        User user = userRepository.findByUsername(username);

        if(user == null) throw new UsernameNotFoundException(username);

        return new UserSecurity(
                user.getId(),
                user.getUsername(),
                user.getPassword(),
                user.getRoles()
        );
    }
}
