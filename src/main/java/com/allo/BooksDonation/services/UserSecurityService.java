package com.allo.BooksDonation.services;


import com.allo.BooksDonation.entities.enums.Roles;
import com.allo.BooksDonation.exceptions.AuthorizationException;
import com.allo.BooksDonation.exceptions.IllegalStateException;
import com.allo.BooksDonation.security.UserSecurity;
import org.springframework.security.core.context.SecurityContextHolder;

public class UserSecurityService {

    private UserSecurityService() {
        throw new IllegalStateException("Error");
    }

    public static UserSecurity authenticate(){
       return (UserSecurity) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    }

    public static void verificaUsuarioLogado(Long id){
        UserSecurity userSecurity = authenticate();

        if(
            userSecurity == null
            || !userSecurity.hasRole(Roles.ADMIN)
            && !id.equals(userSecurity.getId())
        ) throw new AuthorizationException("Access denied");
    }
}
