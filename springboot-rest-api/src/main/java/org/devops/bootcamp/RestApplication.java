package org.devops.bootcamp;

// import org.devops.bootcamp.models.Product;
// import org.devops.bootcamp.models.Order;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RestApplication {

    public static void main(String[] args) {

        SpringApplication.run(RestApplication.class, args);

        // Product p = Product.builder()
        //         .name("Milk")
        //         .description("Normal")
        //         .price(6.5).build();
        
        // Order o = Order.builder()
        //         .total(100.0)
        //         .client("Carlos")
        //         .productList(null).build();
    //    System.out.println(p.getName() + p.getDescription() + p.getPrice());

    }

}
