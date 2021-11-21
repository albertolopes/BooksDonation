package com.allo.booksdonation.repositories;

import com.allo.booksdonation.entities.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@DataJpaTest
public class UserRepositoryTest {

    private static String USERNAME = "livros";
    private static String EMAIL = "livros@mail.com";

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TestEntityManager entityManager;

    @Test
    @DisplayName("Must find an user by username")
    public void findByUsername(){
        User response = userRepository.findByUsername(USERNAME);
        Assertions.assertNotNull(response);
    }

    @Test
    @DisplayName("Must find an user by email")
    public void findByEmail(){
        User response = userRepository.findByEmail(EMAIL);
        Assertions.assertNotNull(response);
    }
}
