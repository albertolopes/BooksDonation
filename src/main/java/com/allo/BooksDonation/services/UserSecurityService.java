package com.allo.BooksDonation.services;


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
}
