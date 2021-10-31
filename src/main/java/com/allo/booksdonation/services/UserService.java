package com.allo.booksdonation.services;

import com.allo.booksdonation.dtos.UpdatePasswordDTO;
import com.allo.booksdonation.entities.User;
import com.allo.booksdonation.entities.enums.Roles;
import com.allo.booksdonation.exceptions.AuthorizationException;
import com.allo.booksdonation.exceptions.ObjectAlreadyExistsException;
import com.allo.booksdonation.exceptions.ObjectNotFoundException;
import com.allo.booksdonation.repositories.UserRepository;
import com.allo.booksdonation.security.UserSecurity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder bCrypt;

    public User findById(Long id) {
        UserSecurityService.verificaUsuarioLogado(id);
        return userRepository.findById(id).orElseThrow(() -> new ObjectNotFoundException("User not found."));
    }

    public User createUser(User user) {
        user.setId(null);
        user.setPassword(bCrypt.encode(user.getPassword()));
        user.setRoles(Collections.singleton(Roles.USER));

        createUserValidation(user);

        return userRepository.save(user);
    }

    public User updateUser(User user) {
        UserSecurityService.verificaUsuarioLogado(user.getId());

        updateUserValidation(user);

        user.setPassword(findById(user.getId()).getPassword());

        return userRepository.save(user);
    }

    public String updatePassword(UpdatePasswordDTO dto){
        UserSecurityService.verificaUsuarioLogado(dto.getId());

        User currentUser = findById(dto.getId());

        currentUser.setPassword(bCrypt.encode(dto.getPassword()));
        userRepository.save(currentUser);

        return "User's password was updated.";
    }

    public void createUserValidation(User user){
        if(userRepository.findByUsername(user.getUsername()) != null){
            throw new ObjectAlreadyExistsException("User already exists. User: " + user.getUsername());
        }

        if(userRepository.findByEmail(user.getEmail()) != null){
            throw new ObjectAlreadyExistsException("Email already exists. Email: " + user.getEmail());
        }
    };

    public void updateUserValidation(User user){
        User username = userRepository.findByUsername(user.getUsername());
        if(username != null && username.getId() != user.getId()){
            throw new ObjectAlreadyExistsException("User already exists. User: " + user.getUsername());
        }

        User email = userRepository.findByEmail(user.getEmail());
        if(email != null && email.getId() != user.getId()){
            throw new ObjectAlreadyExistsException("Email already exists. Email: " + user.getEmail());
        }
    }
}
