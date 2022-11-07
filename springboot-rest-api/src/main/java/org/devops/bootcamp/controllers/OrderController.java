package org.devops.bootcamp.controllers;

import org.devops.bootcamp.models.Order;
import org.devops.bootcamp.services.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/order")
public class OrderController {
    @Autowired
    private Service<Order> orderService;

//    public orderController(Service orderService) {
//        this.orderService = orderService;
//    }

    @GetMapping
    public List<Order> getAll() {
        return orderService.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Order> getorder(@PathVariable("id") Long id) {
        Order order = orderService.getById(id);
        return new ResponseEntity<>(order, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Order> saveorder(@RequestBody Order o) {
        Order order = orderService.insert(o);
        var httpHeaders = new HttpHeaders();
        httpHeaders.add("order", "/api/v1/order/" + order.getId());
        return new ResponseEntity<>(order, httpHeaders, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Order> deleteorder(@PathVariable("id") Long id) {
        Order order = orderService.delete(id);
        return new ResponseEntity<>(order, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Order> updateorder(@PathVariable("id") Long id, @RequestBody Order p){
        Order order = orderService.update(id, p);
        var httpHeaders = new HttpHeaders();
        httpHeaders.add("order", "/api/v1/order/" + order.getId());
        return new ResponseEntity<>(order, httpHeaders, HttpStatus.CREATED);
    }
}