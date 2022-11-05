package org.devops.bootcamp.controllers;

import java.util.List;
import java.util.Optional;

import org.devops.bootcamp.models.Order;
import org.devops.bootcamp.models.Product;
import org.devops.bootcamp.repositories.IOrderRepository;
import org.devops.bootcamp.repositories.IProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    IOrderRepository iOrderRepository;

    @Autowired
    IProductRepository iProductRepository;

    @GetMapping
    public List<Order> getAll(){
        return iOrderRepository.findAll();
    }

    @PostMapping
    public ResponseEntity<Order> saveOrder(@RequestBody Order o){
        try{
            Order order = iOrderRepository
                .save(new Order(o.getTotal(), o.getClient()));
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
        Optional<Order> orderData = iOrderRepository.findById(orderId);
        Optional<Product> productData = iProductRepository.findById(productId);
        if(orderData.isPresent() && productData.isPresent()){
            Order order = orderData.get();
            order.products(productData.get());

            return new ResponseEntity<>(iOrderRepository.save(order), HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
