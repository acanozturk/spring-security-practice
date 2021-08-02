package com.practice.springsecurity.controllers;

import com.practice.springsecurity.entities.Customer;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class AccountController {

    @GetMapping("/api/account")
    private String accountTest(@RequestBody final Customer customer) {
        final String firstName = customer.getFirstName();
        final String lastName = customer.getLastName();
        final String fullName = firstName + " " + lastName;

        return "Welcome " + fullName;
    }
}
