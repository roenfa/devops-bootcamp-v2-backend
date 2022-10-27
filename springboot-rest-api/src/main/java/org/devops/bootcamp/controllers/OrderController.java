package org.devops.bootcamp.controllers;

import java.util.List;

import org.devops.bootcamp.models.Order;
import org.devops.bootcamp.services.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/order")
public class OrderController {

    @Autowired
    private Service<Order> oService;

    @GetMapping
    public List<Order> getAll() {
        return oService.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Order> getOrder(@PathVariable("id") Integer id) {
        Order order = oService.getById(id);
        return new ResponseEntity<Order>(order, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Order> saveOrder(@RequestBody Order o) {
        Order order = oService.insert(o);
        HttpHeaders httpHeaders = new HttpHeaders();

        httpHeaders.add("order", "/api/v1/order/" + order.getOrderId());
        return new ResponseEntity<>(order, httpHeaders, HttpStatus.CREATED);
    }
}
