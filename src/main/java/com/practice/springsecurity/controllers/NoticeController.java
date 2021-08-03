package com.practice.springsecurity.controllers;

import com.practice.springsecurity.entities.Notice;
import com.practice.springsecurity.services.NoticeService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class NoticeController {

    private final NoticeService noticeService;

    @GetMapping("/notices")
    public List<Notice> getNoticesRequest() {

        return noticeService.getNotices();
    }

}
