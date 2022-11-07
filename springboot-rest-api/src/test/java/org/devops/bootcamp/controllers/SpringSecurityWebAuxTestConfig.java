package org.devops.bootcamp.controllers;

import org.devops.bootcamp.security.models.JwtRequest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

import java.util.ArrayList;
import java.util.Arrays;

@TestConfiguration
public class SpringSecurityWebAuxTestConfig {


    @Bean
    @Primary
    public UserDetailsService userDetailsService() {

        JwtRequest user = new JwtRequest("jsdafuanito", "password");

        //JwtUserDetailsService


        return new InMemoryUserDetailsManager(Arrays.asList(
                org.springframework.security.core.userdetails.User.withUsername(user.getUsername())
                        .password(user.getPassword())
                        .authorities(new ArrayList<>())
                        .build()));

    }


}