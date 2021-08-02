package com.practice.springsecurity.security.config.userdetails;

import com.practice.springsecurity.entities.Customer;
import com.practice.springsecurity.repositories.CustomerRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CustomerDetailsService implements UserDetailsService {

    private final CustomerRepository customerRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        final Customer customer = customerRepository.findByEmail(username);

        if(customer == null) {
            throw new UsernameNotFoundException("User not found.");
        }

        return new CustomerSecurity(customer);
    }
}
