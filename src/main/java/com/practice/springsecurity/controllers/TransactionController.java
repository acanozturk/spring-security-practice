package com.practice.springsecurity.controllers;

import com.practice.springsecurity.entities.Customer;
import com.practice.springsecurity.entities.Transaction;
import com.practice.springsecurity.services.TransactionService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class TransactionController {

    private final TransactionService transactionService;

    @PostMapping("/transactions")
    public List<Transaction> getTransactionDetailsRequest(@RequestBody final Customer customer) {

        return transactionService.getTransactionDetails(customer);
    }

}
