package org.devops.bootcamp.services;

import org.devops.bootcamp.exceptions.NoSuchElementFoundException;
import org.devops.bootcamp.models.Order;
import org.devops.bootcamp.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    private OrderRepository orderRepository;

    @Autowired
    public OrderServiceImpl(OrderRepository orderRepository){
        this.orderRepository = orderRepository;
    }

    @Override
    public List<Order> getAll() {
        return this.orderRepository.getAll();
    }

    @Override
    public Order getById(int id) throws NoSuchElementFoundException {
        return this.orderRepository.getById(id);
    }

    @Override
    public Order insert(Order p) {
        return this.orderRepository.save(p);
    }

    @Override
    public void update(int id, Order p) {
        this.orderRepository.save(p);
    }

    @Override
    public void delete(int id) {
        this.orderRepository.delete(this.orderRepository.getById(id));
    }

}
