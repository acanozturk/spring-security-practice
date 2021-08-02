package com.practice.springsecurity.security.config;

import com.practice.springsecurity.security.config.authentication.AuthLevel;
import com.practice.springsecurity.security.config.authentication.AuthLevelConfig;
import com.practice.springsecurity.security.config.authentication.UserDetailsConfig;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
@AllArgsConstructor
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    private final AuthLevelConfig authLevelConfig;
    private final UserDetailsConfig userDetailsConfig;

    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        authLevelConfig.setConfiguration(httpSecurity, AuthLevel.NORMAL);
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        userDetailsConfig.setConfiguration(auth);
    }
}
