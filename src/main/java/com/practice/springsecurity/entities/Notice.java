package com.practice.springsecurity.entities;

import lombok.Data;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;

@Data
@Entity
@Table(name = "notices")
public class Notice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer noticeId;

    private String noticeSummary;
    private String noticeDetails;
    private Date noticBegDt;
    private Date noticEndDt;
    private Timestamp createdAt;
    private Date updatedAt;

}
