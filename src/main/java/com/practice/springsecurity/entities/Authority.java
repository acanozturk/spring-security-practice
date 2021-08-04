package com.practice.springsecurity.entities;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.sql.Timestamp;

@Data
@Entity
@Table(name = "authorities")
public class Authority {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @EqualsAndHashCode.Exclude
    @JoinColumn(name = "customer_id")
    private Customer customer;

    private String name;
    private Timestamp createdAt;

}
