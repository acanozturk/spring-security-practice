package com.practice.springsecurity.services;

import com.practice.springsecurity.entities.Customer;
import com.practice.springsecurity.entities.Transaction;
import com.practice.springsecurity.repositories.TransactionRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class TransactionService {

    private final TransactionRepository transactionRepository;

    public List<Transaction> getTransactionDetails(final Customer customer) {
        final Integer customerId = customer.getCustomerId();

        return transactionRepository.findByCustomerIdOrderByTransactionDtDesc(customerId);
    }

}
