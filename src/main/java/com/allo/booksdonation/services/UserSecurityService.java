package com.allo.booksdonation.services;


import com.allo.booksdonation.entities.enums.Roles;
import com.allo.booksdonation.exceptions.AuthorizationException;
import com.allo.booksdonation.exceptions.IllegalStateException;
import com.allo.booksdonation.security.UserSecurity;
import org.springframework.security.core.context.SecurityContextHolder;

public class UserSecurityService {

    private UserSecurityService() {
        throw new IllegalStateException("Error");
    }

    public static UserSecurity authenticate(){
       return (UserSecurity) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    }

    public static void verifyUserLogged(Long id){
        UserSecurity userSecurity = authenticate();

        if(
            userSecurity == null
            || !userSecurity.hasRole(Roles.ADMIN)
            && !id.equals(userSecurity.getId())
        ) throw new AuthorizationException("Access denied");
    }
}
