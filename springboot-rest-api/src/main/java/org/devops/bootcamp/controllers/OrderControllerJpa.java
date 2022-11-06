package org.devops.bootcamp.controllers;

import java.util.List;

import org.devops.bootcamp.models.Order;
import org.devops.bootcamp.models.Product;
import org.devops.bootcamp.services_jpa.OrderServiceJpa;
import org.devops.bootcamp.services_jpa.ProductServiceJpa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v2/orders")
public class OrderControllerJpa {
    
    @Autowired
    OrderServiceJpa orderServiceJpa;

    @Autowired
    ProductServiceJpa productServiceJpa;

    @GetMapping
    public List<Order> getAll(){
        return orderServiceJpa.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Order> getOrder(@PathVariable("id") long id){
        Order order = orderServiceJpa.getById(id);
        return new ResponseEntity<>(order, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Order> saveOrder(@RequestBody Order o){
        try{
            Order order = orderServiceJpa.save(o);
            return new ResponseEntity<>(order, HttpStatus.CREATED);
        }catch(Exception exc){
            System.out.println(exc.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{orderId}/orders/{productId}")
    public ResponseEntity<Order> ordersProduct(
        @PathVariable Long orderId,
        @PathVariable Long productId
    ){
        
        Order order = orderServiceJpa.getById(orderId);
        Product product = productServiceJpa.getById(productId);
        order.setProductsList(product);
        double orderTotal = order.getTotal() + product.getPrice();
        order.setTotal(orderTotal);

        return new ResponseEntity<>(orderServiceJpa.save(order), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Order> orderDelete(@PathVariable long id){
        orderServiceJpa.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    // TODO list of products by order id 
    @GetMapping("/{id}/products")
    public ResponseEntity<List<Product>> orderProducts(@PathVariable long id){
        List<Product> products = orderServiceJpa.getProductsFromOrder(id);
            
        return new ResponseEntity<>(products, HttpStatus.OK);
    }
}
