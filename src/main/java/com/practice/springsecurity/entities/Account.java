package com.practice.springsecurity.entities;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "accounts")
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer accountId;

    private Integer customerId;
    private String accountType;
    private String branchAddress;
    private String createdAt;

}
