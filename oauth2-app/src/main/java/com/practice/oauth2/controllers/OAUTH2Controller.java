package com.practice.oauth2.controllers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@Slf4j
public class OAUTH2Controller {

    @GetMapping("/")
    public String main(final OAuth2AuthenticationToken token) {
        log.info(token.getPrincipal().toString());

        return "index.html";
    }

}
