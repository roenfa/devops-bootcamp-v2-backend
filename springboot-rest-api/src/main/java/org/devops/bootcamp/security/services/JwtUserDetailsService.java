package org.devops.bootcamp.security.services;

import org.devops.bootcamp.security.models.User;
import org.devops.bootcamp.security.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

// Implements from UserDetailsService (is used in order to search the username, password and authorities for a given user)
// Loads hardcoded username and password

@Service
public class JwtUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> foundUser = this.userRepository.findByUsername(username);

        if (foundUser.isPresent()) {
            return foundUser.get();
        }

        throw new UsernameNotFoundException("User not found with username: "+ username);
    }

}