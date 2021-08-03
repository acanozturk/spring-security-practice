package com.practice.springsecurity.security.config.userdetails;

import com.practice.springsecurity.entities.Customer;
import lombok.AllArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@AllArgsConstructor
public class UserDetailsImpl implements UserDetails {

    private static final long serialVersionUID = -6690946490872875352L;

    private final Customer customer;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        final List<GrantedAuthority> authorities = new ArrayList<>();

        authorities.add(new SimpleGrantedAuthority(setAuthorities()));

        return authorities;
    }

    private String setAuthorities() {

        return customer.getRole().name().toLowerCase();
    }

    @Override
    public String getPassword() {

        return customer.getPassword();
    }

    @Override
    public String getUsername() {

        return customer.getEmail();
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
}
