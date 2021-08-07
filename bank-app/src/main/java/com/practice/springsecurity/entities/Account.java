package com.practice.springsecurity.entities;

import lombok.Data;

import javax.persistence.*;
import java.sql.Timestamp;

@Data
@Entity
@Table(name = "accounts")
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer accountNumber;

    private Integer customerId;
    private String accountType;
    private String branchAddress;
    private Timestamp createdAt;

}
