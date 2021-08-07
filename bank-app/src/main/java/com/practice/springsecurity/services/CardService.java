package com.practice.springsecurity.services;

import com.practice.springsecurity.entities.Card;
import com.practice.springsecurity.entities.Customer;
import com.practice.springsecurity.repositories.CardRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CardService {

    private final CardRepository cardRepository;

    public List<Card> getCardDetails(final Customer customer) {
        final Integer customerId = customer.getCustomerId();

        return cardRepository.findByCustomerId(customerId);
    }

}
