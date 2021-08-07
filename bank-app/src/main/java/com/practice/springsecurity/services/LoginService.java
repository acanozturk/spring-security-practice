package com.practice.springsecurity.services;

import com.practice.springsecurity.entities.Customer;
import com.practice.springsecurity.repositories.CustomerRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.security.Principal;

@Service
@AllArgsConstructor
public class LoginService {

    private final CustomerRepository customerRepository;

    public Customer login(final Principal user) {
        final String email = user.getName();

        return customerRepository.findByEmail(email);
    }

}
