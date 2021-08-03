package com.practice.springsecurity.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "customers")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer customerId;

    private String firstName;
    private String lastName;
    private String email;
    private String phone;

    @JsonIgnore
    private String password;

    private String role;
    private String createdAt;

}
