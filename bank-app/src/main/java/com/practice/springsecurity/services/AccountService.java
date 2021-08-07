package com.practice.springsecurity.services;

import com.practice.springsecurity.entities.Account;
import com.practice.springsecurity.entities.Customer;
import com.practice.springsecurity.repositories.AccountRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AccountService {

    private final AccountRepository accountRepository;

    public Account getAccountDetails(final Customer customer) {
        final Integer customerId = customer.getCustomerId();

        return accountRepository.findByCustomerId(customerId);
    }

}
