package org.devops.bootcamp.controllers;

import org.devops.bootcamp.models.Order;
import org.devops.bootcamp.services.OrderServiceV2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping("/api/v2/orders")
public class OrderControllerV2 {
    @Autowired
    OrderServiceV2 orderServiceV2;

    @GetMapping
    public ArrayList<Order> getAll(){
        return orderServiceV2.getAllOrders();
    }

    @PostMapping
    public Order saveOrder(@RequestBody Order order){
        return orderServiceV2.saveOrder(order);
    }

    @GetMapping(path = "/{id}")
    public Optional<Order> getOrderById(@PathVariable("id") Integer id){
        return orderServiceV2.getById(id);
    }

    @DeleteMapping(path = "/{id}")
    public String deleteOrder(@PathVariable("id") Integer id){
        boolean ok = orderServiceV2.deleteProduct(id);
        if(ok){
            return "Order deleted";
        }
        else{
            return "Order not found";
        }
    }
}
