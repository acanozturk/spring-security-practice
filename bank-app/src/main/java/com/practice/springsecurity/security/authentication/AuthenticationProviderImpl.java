package com.practice.springsecurity.security.authentication;

import com.practice.springsecurity.entities.Authority;
import com.practice.springsecurity.entities.Customer;
import com.practice.springsecurity.repositories.CustomerRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Component
@AllArgsConstructor
public class AuthenticationProviderImpl implements AuthenticationProvider {

    private final BCryptPasswordEncoder passwordEncoder;

    private final CustomerRepository customerRepository;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        final String username = authentication.getName();
        final String credentials = authentication.getCredentials().toString();
        final Customer customer = customerRepository.findByEmail(username);

        if (customer != null) {
            if (passwordEncoder.matches(credentials, customer.getPwd())) {
                final Set<Authority> authorities = customer.getAuthorities();

                return generateAuthToken(username, credentials, authorities);
            } else {
                throw new BadCredentialsException("Invalid credentials.");
            }
        } else {
            throw new BadCredentialsException("User not found.");
        }
    }

    private UsernamePasswordAuthenticationToken generateAuthToken(final String username, final String credentials,
                                                                  final Set<Authority> authorities) {

        final List<GrantedAuthority> userAuthorities = getAuthorities(authorities);

        return new UsernamePasswordAuthenticationToken(username, credentials, userAuthorities);
    }


    private List<GrantedAuthority> getAuthorities(final Set<Authority> userAuthorities) {
        final List<GrantedAuthority> grantedAuthorities = new ArrayList<>();

        for (Authority authority : userAuthorities) {
            grantedAuthorities.add(new SimpleGrantedAuthority(authority.getName()));
        }

        return grantedAuthorities;
    }

    @Override
    public boolean supports(Class<?> aClass) {

        return aClass.equals(UsernamePasswordAuthenticationToken.class);
    }
}
