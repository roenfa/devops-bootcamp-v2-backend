package org.devops.bootcamp.controllers;

import java.util.List;

import org.devops.bootcamp.models.Order;
import org.devops.bootcamp.repositories.IOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v2/orders")
public class OrderControllerJpa {
    
    @Autowired
    IOrderRepository iOrderRepository;

    @GetMapping
    public List<Order> getAll(){
        return iOrderRepository.findAll();
    }
}
