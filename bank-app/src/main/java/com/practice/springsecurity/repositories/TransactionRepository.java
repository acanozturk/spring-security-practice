package com.practice.springsecurity.repositories;

import com.practice.springsecurity.entities.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Integer> {

    List<Transaction> findByCustomerIdOrderByTransactionDtDesc(Integer customerId);

}
