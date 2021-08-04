package com.practice.springsecurity.security.filters;

import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.util.StringUtils;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

import static org.springframework.http.HttpHeaders.AUTHORIZATION;

public class AuthValidationFilter implements Filter {

    private static final String FILTER = "test";
    private static final String AUTH_SCHEME_BASIC = "Basic";
    private final Charset credentialsCharset = StandardCharsets.UTF_8;

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain)
            throws IOException, ServletException {

        final HttpServletRequest servletRequest = (HttpServletRequest) request;
        final HttpServletResponse servletResponse = (HttpServletResponse) response;

        String authHeader = servletRequest.getHeader(AUTHORIZATION);

        if(authHeader != null) {
            authHeader = authHeader.trim();

            if(StringUtils.startsWithIgnoreCase(authHeader, AUTH_SCHEME_BASIC)) {
                applyFilter(authHeader, servletResponse);
            }
        }

        filterChain.doFilter(request, response);
    }

    private void applyFilter(final String authHeader, final HttpServletResponse servletResponse) {
        try {
            final byte[] base64Token = authHeader.substring(6).getBytes(StandardCharsets.UTF_8);
            final byte[] decodedToken = Base64.getDecoder().decode(base64Token);
            final String token = new String(decodedToken, credentialsCharset);
            int delimiter = token.indexOf(":");

            if (delimiter == -1) {
                throw new BadCredentialsException("Invalid basic authentication token");
            }

            final String email = token.substring(0, delimiter);

            if(email.toLowerCase().contains(FILTER)) {
                servletResponse.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            }
        } catch (IllegalArgumentException e) {
            throw new BadCredentialsException("Failed to decode basic authentication token");
        }
    }

}
