package com.practice.springsecurity.repositories;

import com.practice.springsecurity.entities.Notice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NoticeRepository extends JpaRepository<Notice, Integer> {

    @Query(value = "SELECT n FROM Notice n")
    List<Notice> findAllActiveNotices();

}
