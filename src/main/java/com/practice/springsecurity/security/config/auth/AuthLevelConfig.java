package com.practice.springsecurity.security.config.auth;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;
import org.springframework.web.cors.CorsConfiguration;

import java.util.Collections;

@Configuration
@Slf4j
public class AuthLevelConfig {

    public void setConfiguration(final HttpSecurity httpSecurity, final AuthLevel authLevel) throws Exception {
        switch (authLevel) {
            case NORMAL:
                normalAuthConfig(httpSecurity);
                break;
            case PERMIT_ALL:
                permitAllAuthConfig(httpSecurity);
                break;
            case DENY_ALL:
                denyAllAuthConfig(httpSecurity);
                break;
        }
    }

    private void normalAuthConfig(final HttpSecurity httpSecurity) throws Exception {
        httpSecurity
                .cors()
                .configurationSource(request -> setCorsConfig())
                .and()
                .csrf()
                .ignoringAntMatchers("/contact").csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse())
                .and()
                .authorizeRequests()
                .antMatchers("/account").authenticated()
                .antMatchers("/balance").authenticated()
                .antMatchers("/loans").authenticated()
                .antMatchers("/cards").authenticated()
                .antMatchers("/user").authenticated()
                .antMatchers("/notices").permitAll()
                .antMatchers("/contact").permitAll()
                .and()
                .httpBasic();

        log.info("Authentication configuration is set to NORMAL.");
    }

    private CorsConfiguration setCorsConfig() {
        final CorsConfiguration config = new CorsConfiguration();

        config.setAllowedOrigins(Collections.singletonList("http://localhost:4200"));
        config.setAllowedMethods(Collections.singletonList("*"));
        config.setAllowCredentials(true);
        config.setAllowedHeaders(Collections.singletonList("*"));
        config.setMaxAge(3600L);

        return config;
    }

    private void permitAllAuthConfig(final HttpSecurity httpSecurity) throws Exception {
        httpSecurity
                .authorizeRequests()
                .anyRequest()
                .permitAll()
                .and()
                .formLogin()
                .and()
                .httpBasic();

        log.info("Authentication configuration is set to PERMIT-ALL.");
    }

    private void denyAllAuthConfig(final HttpSecurity httpSecurity) throws Exception {
        httpSecurity
                .authorizeRequests()
                .anyRequest()
                .denyAll()
                .and()
                .formLogin()
                .and()
                .httpBasic();

        log.info("Authentication configuration is set to DENY-ALL.");
    }

}
