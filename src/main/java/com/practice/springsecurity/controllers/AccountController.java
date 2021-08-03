package com.practice.springsecurity.controllers;

import com.practice.springsecurity.entities.Account;
import com.practice.springsecurity.entities.Customer;
import com.practice.springsecurity.services.AccountService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class AccountController {

    private final AccountService accountService;

    @PostMapping("/account")
    public Account getAccountDetailsRequest(@RequestBody final Customer customer) {

        return accountService.getAccountDetails(customer);
    }
}
