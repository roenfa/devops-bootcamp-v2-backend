package org.devops.bootcamp.services;


import org.devops.bootcamp.models.Order;
import org.devops.bootcamp.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@org.springframework.stereotype.Service
public class OrderServiceImpl implements Service<Order>{

    @Autowired
    OrderRepository orderRepository;
    @Override
    public List<Order> getAll() {
        return orderRepository.getAllOrders();
    }

    @Override
    public Order getById(int id) {
        Order order = null;
        if(orderRepository.getById(id) != null){
            order = orderRepository.getById(id);
        }
        return order;
    }

    @Override
    public Order insert(Order p) {
        return orderRepository.save(p);
    }

    @Override
    public void update(int id, Order p) {

    }

    @Override
    public void delete(int id) {

    }
}
