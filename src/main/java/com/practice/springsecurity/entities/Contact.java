package com.practice.springsecurity.entities;

import lombok.Data;

import javax.persistence.*;
import java.sql.Timestamp;

@Data
@Entity
@Table(name = "contacts")
public class Contact {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer contactId;

    private String contactName;
    private String contactEmail;
    private String subject;
    private String message;
    private Timestamp createdAt;

}
