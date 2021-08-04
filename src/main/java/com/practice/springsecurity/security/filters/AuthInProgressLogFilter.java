package com.practice.springsecurity.security.filters;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.*;
import java.io.IOException;

@Slf4j
public class AuthInProgressLogFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain)
            throws IOException, ServletException {

        log.info("Authentication is in progress...");

        filterChain.doFilter(request, response);
    }
}
