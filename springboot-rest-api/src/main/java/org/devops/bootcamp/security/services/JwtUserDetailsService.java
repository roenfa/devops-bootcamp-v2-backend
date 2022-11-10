package org.devops.bootcamp.security.services;

import org.devops.bootcamp.models.User;
import org.devops.bootcamp.repositories.IUserRepository;
import org.devops.bootcamp.security.MyUserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

// import java.util.ArrayList;

// Implements from UserDetailsService (is used in order to search the username, password and authorities for a given user)
// Loads hardcoded username and password
@Service
public class JwtUserDetailsService implements UserDetailsService {

    @Autowired
    private IUserRepository iUserRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = iUserRepository.getUserByUsername(username);

        if(user == null){
            throw new UsernameNotFoundException("Couldn't find user");
        }

        return new MyUserDetails(user);
    }

}