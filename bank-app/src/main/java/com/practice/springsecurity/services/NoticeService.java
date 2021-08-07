package com.practice.springsecurity.services;

import com.practice.springsecurity.entities.Notice;
import com.practice.springsecurity.repositories.NoticeRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class NoticeService {

    private final NoticeRepository noticeRepository;

    public List<Notice> getNotices() {

        return noticeRepository.findAllActiveNotices();
    }

}
