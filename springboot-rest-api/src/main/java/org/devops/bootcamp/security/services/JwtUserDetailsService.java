package org.devops.bootcamp.security.services;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

// Implements from UserDetailsService (is used in order to search the username, password and authorities for a given user)
// Loads hardcoded username and password
// TODO: Integrate with sql server manager
@Service
public class JwtUserDetailsService implements UserDetailsService {

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        if ("bootcamp".equals(username)) {
            return new User("bootcamp", "$2a$10$bE17.Oa2jMLEm1lKXvxhlu4ZRMbYFQ4QiWz/u0lSH3Pp5hNiLBzBO",
                    new ArrayList<>());
        } else {
            throw new UsernameNotFoundException("User not found with username: " + username);
        }
    }

}