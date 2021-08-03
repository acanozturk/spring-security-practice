package com.practice.springsecurity.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.sql.Timestamp;

@Data
@Entity
@Table(name = "customers")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer customerId;

    private String name;
    private String email;
    private String mobileNumber;

    @JsonIgnore
    private String pwd;

    private String role;
    private Timestamp createdAt;

}
