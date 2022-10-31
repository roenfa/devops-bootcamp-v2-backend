package org.devops.bootcamp.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private PasswordEncoder passwordEncoder;
//    @Bean
//    public PasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();
//    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth
                // enable in memory based authentication with a user named "user" and "admin"
                .inMemoryAuthentication().withUser("user").password(passwordEncoder.encode("password")).roles("USER")
                .and().withUser("admin").password("$2a$12$UskmEYYJdlw/7F2t0sKudugQNUGuAnphHqA6qIod5ljGn419tVd/6").roles("USER", "ADMIN");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf()
                .disable()
                .authorizeRequests()
                .antMatchers(HttpMethod.GET, "/api/v1/products/**").hasRole("USER")
                .antMatchers(HttpMethod.POST, "/api/v1/products/**").hasRole("ADMIN,USER")
                .antMatchers(HttpMethod.DELETE, "/api/v1/products/**").hasRole("ADMIN")
//                .permitAll()
                .anyRequest()
//                .hasRole("USER")
//                .and()
                // Possibly more configuration ...
//                .formLogin() // enable form based log in
                // set permitAll for all URLs associated with Form Login
                .authenticated()
                .and()
                .httpBasic();
    }

// CROSS-SITE REQUEST FORGERY CSRF
//    POST /transfer
//    amount=4000&routingNumber=789456&account=456
//    cookie: xtoken=45467812134548
//
//    <form method="post">
//        <input name="amount" value="5000">
//        <input name="account" value="123">
//    </form>
}
