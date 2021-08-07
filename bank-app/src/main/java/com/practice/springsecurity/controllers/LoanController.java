package com.practice.springsecurity.controllers;

import com.practice.springsecurity.entities.Customer;
import com.practice.springsecurity.entities.Loan;
import com.practice.springsecurity.services.LoanService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class LoanController {

    private final LoanService loanService;

    @PostMapping("/loans")
    public List<Loan> getLoanDetailsRequest(@RequestBody final Customer customer) {

        return loanService.getLoanDetails(customer);
    }

}
