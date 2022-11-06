package org.devops.bootcamp;

import org.devops.bootcamp.models.Product;
import org.devops.bootcamp.repositories.impl.ProductRepositoryImpl;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.transaction.annotation.Transactional;

@SpringBootApplication
public class RestApplication {

    public static void main(String[] args) {
        SpringApplication.run(RestApplication.class, args);
    }

    @Bean
    @Transactional
    CommandLineRunner commandLineRunner(ProductRepositoryImpl productRepository){
        return args -> {
        };
    }

}
