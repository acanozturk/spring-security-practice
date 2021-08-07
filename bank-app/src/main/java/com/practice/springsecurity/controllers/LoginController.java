package com.practice.springsecurity.controllers;

import com.practice.springsecurity.entities.Customer;
import com.practice.springsecurity.services.LoginService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
@AllArgsConstructor
public class LoginController {

    private final LoginService loginService;

    @RequestMapping("/login")
    public Customer loginRequest(final Principal user) {

        return loginService.login(user);
    }

}
