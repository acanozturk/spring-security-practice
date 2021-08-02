package com.practice.springsecurity.security.config;

import com.practice.springsecurity.security.config.authconfigs.AuthLevel;
import com.practice.springsecurity.security.config.authconfigs.AuthLevelConfig;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
@AllArgsConstructor
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final AuthLevelConfig authLevelConfig;

    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        authLevelConfig.setAuthLevel(httpSecurity, AuthLevel.PERMIT_ALL);
    }
}
