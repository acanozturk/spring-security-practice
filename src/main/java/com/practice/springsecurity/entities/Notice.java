package com.practice.springsecurity.entities;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "notices")
public class Notice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer noticeId;

    private String noticeSummary;
    private String noticeDetails;
    private String beginDate;
    private String endDate;
    private String createdAt;
    private String updatedAt;

}
