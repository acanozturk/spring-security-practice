package com.practice.springsecurity.entities;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "cards")
public class Card {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer cardId;

    private Integer customerId;
    private String cardNumber;
    private String cardType;
    private Integer totalLimit;
    private Integer amountUsed;
    private Integer amountAvailable;
    private String createdAt;

}
