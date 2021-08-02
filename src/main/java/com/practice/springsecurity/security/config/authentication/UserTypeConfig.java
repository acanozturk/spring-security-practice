package com.practice.springsecurity.security.config.authentication;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
@Slf4j
public class UserTypeConfig {

    @Bean
    public PasswordEncoder passwordEncoder() {

        return NoOpPasswordEncoder.getInstance();
    }

    public void setConfiguration(final AuthenticationManagerBuilder auth) throws Exception {
        final InMemoryUserDetailsManager userDetailsService = createInMemoryUserDetailsManager();

        userDetailsService.createUser(createNormalUser());
        userDetailsService.createUser(createAdmin());

        auth.userDetailsService(userDetailsService);

        log.info("User type configuration successful.");
    }

    private InMemoryUserDetailsManager createInMemoryUserDetailsManager() {

        return new InMemoryUserDetailsManager();
    }

    private UserDetails createNormalUser() {

        return User
                .withUsername("user")
                .password("user")
                .authorities("read")
                .build();
    }

    private UserDetails createAdmin() {

        return User
                .withUsername("admin")
                .password("admin")
                .authorities("admin")
                .build();
    }
}
