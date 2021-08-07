package com.practice.springsecurity.services;

import com.practice.springsecurity.entities.Contact;
import com.practice.springsecurity.repositories.ContactRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ContactService {

    private final ContactRepository contactRepository;

    public Contact saveContactDetails(final Contact contact) {

        return contactRepository.save(contact);
    }

}
