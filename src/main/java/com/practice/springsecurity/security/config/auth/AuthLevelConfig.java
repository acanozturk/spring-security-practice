package com.practice.springsecurity.security.config.auth;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;

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
                .authorizeRequests()
                .antMatchers("/api/account").authenticated()
                .antMatchers("/api/balance").authenticated()
                .antMatchers("/api/cards").authenticated()
                .antMatchers("/api/loans").authenticated()
                .antMatchers("/api/contact").permitAll()
                .antMatchers("/api/notices").permitAll()
                .and()
                .formLogin()
                .and()
                .httpBasic();

        log.info("Authentication configuration is set to NORMAL.");
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
