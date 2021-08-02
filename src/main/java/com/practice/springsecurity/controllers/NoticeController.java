package com.practice.springsecurity.controllers;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class NoticeController {

    @GetMapping("/api/notices")
    private String noticeTest() {

        return "notice";
    }
}
