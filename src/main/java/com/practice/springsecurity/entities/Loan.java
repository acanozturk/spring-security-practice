package com.practice.springsecurity.entities;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "loans")
public class Loan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer loanId;

    private Integer customerId;
    private String loanDate;
    private String loanType;
    private String loanAmount;
    private String amountPaid;
    private String amountRemaining;
    private String createdAt;

}
