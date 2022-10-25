package org.devops.bootcamp;

import org.devops.bootcamp.models.Product;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RestApplication {

    public static void main(String[] args) {

        SpringApplication.run(RestApplication.class, args);

        Product p = Product.builder()
                .productId(1)
                .name("Milk")
                .description("Normal")
                .price(6.5).build();

        System.out.println(p.getName() + p.getDescription() + p.getPrice());

    }

}
