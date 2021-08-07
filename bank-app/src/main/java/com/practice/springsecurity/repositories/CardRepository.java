package com.practice.springsecurity.repositories;

import com.practice.springsecurity.entities.Card;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CardRepository extends JpaRepository<Card, Integer> {

    List<Card> findByCustomerId(Integer customerId);

}
