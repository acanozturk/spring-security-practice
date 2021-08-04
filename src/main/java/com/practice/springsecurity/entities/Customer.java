package com.practice.springsecurity.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Set;

@Data
@Entity
@Table(name = "customers")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer customerId;

    @JsonIgnore
    private String pwd;

    @JsonIgnore
    @EqualsAndHashCode.Exclude
    @OneToMany(mappedBy = "customer", fetch = FetchType.EAGER)
    private Set<Authority> authorities;

    private String name;
    private String email;
    private String mobileNumber;
    private String role;
    private Timestamp createdAt;

}
