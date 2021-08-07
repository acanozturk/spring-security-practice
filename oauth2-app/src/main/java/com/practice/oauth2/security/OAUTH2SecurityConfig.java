package com.practice.oauth2.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.oauth2.client.CommonOAuth2Provider;
import org.springframework.security.oauth2.client.registration.ClientRegistration;
import org.springframework.security.oauth2.client.registration.ClientRegistrationRepository;
import org.springframework.security.oauth2.client.registration.InMemoryClientRegistrationRepository;

@Configuration
public class OAUTH2SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity
                .authorizeRequests()
                .anyRequest()
                .authenticated()
                .and()
                .oauth2Login();
    }


    private ClientRegistration clientRegistration() {

        return CommonOAuth2Provider
                .GITHUB.getBuilder("github")
                .clientId("a821c17dcddbc4a704ad")
                .clientSecret("040611197722e10da0d9b37537a7c479257ac146")
                .build();
    }


//    private ClientRegistration clientRegistration() {
//        ClientRegistration cr =
//                ClientRegistration.withRegistrationId("github").clientId(
//                        "3c9be97074f067e78e75")
//                        .clientSecret("ab313f7ade3d79e06c192ca80cf152c43cb5d916").scope(new String[]
//                        {"read:user"})
//                        .authorizationUri("https://github.com/login/oauth/authorize")
//                        .tokenUri("https://github.com/login/oauth/access_token").userInfoUri(
//                        "https://api.github.com/user")
//                        .userNameAttributeName("id").clientName("GitHub")
//                        .authorizationGrantType(AuthorizationGrantType.AUTHORIZATION_CODE)
//                        .redirectUriTemplate("{baseUrl}/{action}/oauth2/code/{registrationId}").build
//                        ();
//        return cr;
//    }


    @Bean
    public ClientRegistrationRepository clientRepository() {
        final ClientRegistration clientReg = clientRegistration();

        return new InMemoryClientRegistrationRepository(clientReg);
    }


}
