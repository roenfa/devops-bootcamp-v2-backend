package org.devops.bootcamp;

import org.devops.bootcamp.models.Order;
import org.devops.bootcamp.models.Product;
import org.devops.bootcamp.repositories.OrderRepository;
import org.devops.bootcamp.repositories.impl.ProductRepositoryImpl;
import org.devops.bootcamp.services.ProductService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class RestApplication {

    public static void main(String[] args) {
        SpringApplication.run(RestApplication.class, args);
    }

    @Bean
    @Transactional
    CommandLineRunner commandLineRunner(ProductService productService){
        return args -> {
            System.out.println(productService.getAll());
        };
    }

}
