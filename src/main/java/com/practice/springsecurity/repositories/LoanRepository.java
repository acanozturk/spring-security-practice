package com.practice.springsecurity.repositories;

import com.practice.springsecurity.entities.Loan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LoanRepository extends JpaRepository<Loan, Integer> {

    List<Loan> findByCustomerIdOrderByStartDtDesc(Integer customerId);

}
