package com.practice.springsecurity.security.config;

import com.practice.springsecurity.security.authentication.AuthLevel;
import com.practice.springsecurity.security.filters.AuthInProgressLogFilter;
import com.practice.springsecurity.security.filters.AuthSuccessfulLogFilter;
import com.practice.springsecurity.security.filters.AuthValidationFilter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;
import org.springframework.web.cors.CorsConfiguration;

import java.util.Collections;

@Configuration
@Slf4j
public class CustomHttpSecurityConfig {

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
                .ignoringAntMatchers("/contact")
                .csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse())
                .and()
                .addFilterBefore(new AuthInProgressLogFilter(), BasicAuthenticationFilter.class)
                .addFilterBefore(new AuthValidationFilter(), BasicAuthenticationFilter.class)
                .addFilterAfter(new AuthSuccessfulLogFilter(), BasicAuthenticationFilter.class)
                .authorizeRequests()
                .mvcMatchers("/account").hasRole("USER")
                .mvcMatchers("/cards").hasAnyRole("USER", "ADMIN")
                .mvcMatchers("/loans").hasRole("ADMIN")
                .mvcMatchers("/transactions").authenticated()
                .mvcMatchers("/login").authenticated()
                .mvcMatchers("/contact").permitAll()
                .mvcMatchers("/notices").permitAll()
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
