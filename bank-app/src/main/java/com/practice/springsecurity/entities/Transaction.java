package com.practice.springsecurity.entities;

import lombok.Data;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;

@Data
@Entity
@Table(name = "transactions")
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer transactionId;

    private Integer account_number;
    private Integer customerId;
    private String transactionSummary;
    private String transactionType;
    private Integer transactionAmt;
    private Integer closingBalance;
    private Date transactionDt;
    private Timestamp createdAt;

}
