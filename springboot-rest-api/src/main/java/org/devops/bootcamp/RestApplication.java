package org.devops.bootcamp;

import org.devops.bootcamp.security.models.Role;
import org.devops.bootcamp.security.models.User;
import org.devops.bootcamp.security.repository.RoleRepository;
import org.devops.bootcamp.security.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.transaction.annotation.Transactional;


@SpringBootApplication
public class RestApplication {

    public static void main(String[] args) {
        SpringApplication.run(RestApplication.class, args);
    }

    @Bean
    @Transactional
    CommandLineRunner commandLineRunner(UserRepository userRepository, RoleRepository roleRepository, BCryptPasswordEncoder bCryptPasswordEncoder){
        return args -> {
            Role adminRole = roleRepository.save(
                    Role.builder().id("ADMIN").build()
            );

            Role userRole = roleRepository.save(
                    Role.builder().id("USER").build()
            );

            userRepository.save(
                    User.builder()
                            .id(1L)
                            .username("admin")
                            .password(bCryptPasswordEncoder.encode("admin"))
                            .role(adminRole)
                            .build()
            );

            userRepository.save(
                    User.builder()
                            .id(2L)
                            .username("user")
                            .password(bCryptPasswordEncoder.encode("user"))
                            .role(userRole)
                            .build()
            );

        };
    }

}
