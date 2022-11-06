package org.devops.bootcamp;

import java.util.List;

import org.devops.bootcamp.models.Product;
import org.devops.bootcamp.models.User;
import org.devops.bootcamp.models.Order;
import org.devops.bootcamp.repositories.IOrderRepository;
import org.devops.bootcamp.repositories.IProductRepository;
import org.devops.bootcamp.repositories.IUserRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
// import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;

@SpringBootApplication
public class RestApplication implements CommandLineRunner {

    // @Autowired
    // private JdbcTemplate jdbcTemplate;

    @Autowired
    private IProductRepository iProductRepository;

    @Autowired
    private IOrderRepository iOrderRepository;

    @Autowired
    private IUserRepository iUserRepository;

    public static void main(String[] args) {

        SpringApplication.run(RestApplication.class, args);

        /* Product p = Product.builder()
                .productId(1)
                .name("Milk")
                .description("Normal")
                .price(6.5).build(); */
    }

    @Override
    public void run(String... args) throws Exception {
        // String sql = "SELECT * FROM dbo.products";
        // List<Product> products = jdbcTemplate.query(sql, 
        //     BeanPropertyRowMapper.newInstance(Product.class));
        // products.forEach(System.out::println);

        List<Product> products = iProductRepository.findAll();
        products.forEach(System.out::println);

        List<Order> orders = iOrderRepository.findAll();
        orders.forEach(System.out::println);

        List<User> users = iUserRepository.findAll();
        users.forEach(System.out::println);
    }

}
