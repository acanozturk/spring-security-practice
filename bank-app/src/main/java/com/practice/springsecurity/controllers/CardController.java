package com.practice.springsecurity.controllers;

import com.practice.springsecurity.entities.Card;
import com.practice.springsecurity.entities.Customer;
import com.practice.springsecurity.services.CardService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class CardController {

    private final CardService cardService;

    @PostMapping("/cards")
    public List<Card> getCardDetailsRequest(@RequestBody final Customer customer) {

        return cardService.getCardDetails(customer);
    }

}
