package com.allo.BooksDonation.services;

import com.allo.BooksDonation.dtos.UpdatePasswordDTO;
import com.allo.BooksDonation.entities.User;
import com.allo.BooksDonation.exceptions.ObjectAlreadyExistsException;
import com.allo.BooksDonation.exceptions.ObjectNotFoundException;
import com.allo.BooksDonation.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User findById(Long id) {
        return userRepository.findById(id).orElseThrow(() -> new ObjectNotFoundException("User not found."));
    }

    public User createUser(User user) {
        createUserValidation(user);
        return userRepository.save(user);
    }

    public User updateUser(User user) {
        updateUserValidation(user);
        user.setPassword(findById(user.getId()).getPassword());
        return userRepository.save(user);
    }

    public String updatePassword(UpdatePasswordDTO dto){
        User currentUser = findById(dto.getId());
        currentUser.setPassword(dto.getPassword());
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
    };
}
