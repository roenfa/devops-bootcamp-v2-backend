package org.devops.bootcamp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;

public class WebSecurityConfigurerAdapter {
    
    @Bean
    public AuthenticationManager authenticationManager() throws Exception {
    return authenticationManager();
}
}
