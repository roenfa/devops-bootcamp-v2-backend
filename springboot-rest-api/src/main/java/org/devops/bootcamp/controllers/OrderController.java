package org.devops.bootcamp.controllers;

import org.devops.bootcamp.models.Order;
import org.devops.bootcamp.services.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/orders")
public class OrderController {
    @Autowired
    private Service<Order> orderService;


    @GetMapping
    public List<Order> getAll() {
        return orderService.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Order> getOrder(@PathVariable("id") Integer id) {
        Order order = orderService.getById(id);
        return new ResponseEntity<>(order, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Order> saveOrder(@Valid @RequestBody Order p) {
        Order order = orderService.insert(p);
        var httpHeaders = new HttpHeaders();
        httpHeaders.add("order", "/api/v1/orders/" + order.getOrderId());
        return new ResponseEntity<>(order, httpHeaders, HttpStatus.CREATED);
    }

}