package com.practice.springsecurity.entities;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "transactions")
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer transactionId;

    private Integer accountId;
    private Integer customerId;
    private String transactionDate;
    private String transactionSummary;
    private String transactionType;
    private Integer transactionAmount;
    private Integer balance;
    private String createdAt;

}
