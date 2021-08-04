package com.practice.springsecurity.security.userdetails;

import com.practice.springsecurity.entities.Authority;
import com.practice.springsecurity.entities.Customer;
import lombok.AllArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

@AllArgsConstructor
public class UserDetailsImpl implements UserDetails {

    private static final long serialVersionUID = -6690946490872875352L;

    private final Customer customer;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        final List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
        final Set<Authority> authorities = customer.getAuthorities();

        for(Authority authority : authorities) {
            grantedAuthorities.add(new SimpleGrantedAuthority(authority.getName()));
        }

        return grantedAuthorities;
    }

    @Override
    public String getPassword() {

        return customer.getPwd();
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
