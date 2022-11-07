package org.devops.bootcamp.security.services;

//import org.devops.bootcamp.models.User;
import org.devops.bootcamp.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

// Implements from UserDetailsService (is used in order to search the username, password and authorities for a given user)
// Loads hardcoded username and password
// TODO: Integrate with sql server manager
@Service
public class JwtUserDetailsService implements UserDetailsService {
    @Autowired
    UserRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        org.devops.bootcamp.models.User userSql = userRepository.findByUsername(username);
        if(userSql != null){
            return new User(userSql.getUsername(),userSql.getPassword(),new ArrayList<>());
        }
        else {
            throw new UsernameNotFoundException("User not found with username: " + username);
        }
//        if ("bootcamp".equals(username)) {
//            return new User("bootcamp", "$2a$10$ixlPY3AAd4ty1l6E2IsQ9OFZi2ba9ZQE0bP7RFcGIWNhyFrrT3YUi",
//                    new ArrayList<>());
//        } else {
//            throw new UsernameNotFoundException("User not found with username: " + username);
//        }
    }

}