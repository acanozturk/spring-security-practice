package com.practice.springsecurity.services;

import com.practice.springsecurity.entities.Customer;
import com.practice.springsecurity.entities.Loan;
import com.practice.springsecurity.repositories.LoanRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class LoanService {

    private final LoanRepository loanRepository;

    public List<Loan> getLoanDetails(final Customer customer) {
        final Integer customerId = customer.getCustomerId();

        return loanRepository.findByCustomerIdOrderByStartDtDesc(customerId);
    }

}
