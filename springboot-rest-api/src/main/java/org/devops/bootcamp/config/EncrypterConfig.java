package org.devops.bootcamp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class EncrypterConfig {
    @Bean
    @Primary
    public PasswordEncoder initEncoder() {
        return new BCryptPasswordEncoder();
    }
}
