package com.allo.BooksDonation.security;

import com.allo.BooksDonation.entities.enums.Roles;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;

public class UserSecurity implements UserDetails {

    private Long id;

    private String username;

    private String password;

    private Collection<? extends GrantedAuthority> authorities;

    public UserSecurity(){

    }

    public UserSecurity(Long id, String username, String password, Set<Roles> roles) {
        super();
        this.id = id;
        this.username = username;
        this.password = password;
        this.authorities = roles.stream().map(role -> new SimpleGrantedAuthority(role.toString())).collect(Collectors.toList());
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public boolean hasRole(Roles perfil){
        return getAuthorities().contains(new SimpleGrantedAuthority(perfil.toString()));
    }
}
