package com.practice.springsecurity.controllers;

import com.practice.springsecurity.entities.Contact;
import com.practice.springsecurity.services.ContactService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class ContactController {

    private final ContactService contactService;

    @PostMapping("/contact")
    public Contact saveContactDetailsRequest(@RequestBody final Contact contact) {

        return contactService.saveContactDetails(contact);
    }

}
