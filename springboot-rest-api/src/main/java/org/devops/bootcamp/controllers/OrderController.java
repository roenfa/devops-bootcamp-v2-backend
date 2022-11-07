package org.devops.bootcamp.controllers;

import org.devops.bootcamp.models.Order;
import org.devops.bootcamp.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;


    @GetMapping
    public ResponseEntity<List<Order>> getAllOrders(){
        return ResponseEntity.ok(this.orderService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Order> getOrderById(@PathVariable("id") Integer id){
        return ResponseEntity.ok(this.orderService.getById(id));
    }

    @PostMapping
    public ResponseEntity<Order> saveOrder(@RequestBody Order order){
        Order savedOrder = this.orderService.insert(order);

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("location", "/api/v1/orders/" + savedOrder.getOrderId() );

        return new ResponseEntity<>(savedOrder, httpHeaders, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<Order> deleteOrder(@PathVariable("id") Integer id){
        this.orderService.delete(id);
        return ResponseEntity.accepted().build();
    }

}
