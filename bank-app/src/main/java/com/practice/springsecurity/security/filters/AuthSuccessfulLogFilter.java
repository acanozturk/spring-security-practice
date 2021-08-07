package com.practice.springsecurity.security.filters;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;

import javax.servlet.*;
import java.io.IOException;
import java.util.Collection;

@Slf4j
public class AuthSuccessfulLogFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain)
            throws IOException, ServletException {

        final Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        final String name = authentication.getName();
        final Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();

        if(authorities.size() > 0) {
            log.info("Authentication successful for user " + name + " with authorities " + authorities.toString());
        } else {
            log.info("Authentication failed for user " + name);
        }

        filterChain.doFilter(request, response);
    }
}
