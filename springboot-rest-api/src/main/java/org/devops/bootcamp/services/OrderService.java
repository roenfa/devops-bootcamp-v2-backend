package org.devops.bootcamp.services;

import org.devops.bootcamp.exceptions.NoSuchElementFoundException;
import org.devops.bootcamp.repositories.OrderRepository;
import org.devops.bootcamp.models.Order;


import java.util.List;

@org.springframework.stereotype.Service
public class OrderService implements Service<Order> {
    private OrderRepository orderRepository;
    public OrderService(OrderRepository repository) {
        this.orderRepository = repository;
    }

    @Override
    public List getAll() {
        return orderRepository.getAllOrders();
    }

    @Override
    public Order getById(int id) throws NoSuchElementFoundException {
        Order order = null;

        var messageError = "Order with id = " + id + " not found!!!";

        if (orderRepository.getById(id) == null) {
            throw new NoSuchElementFoundException(messageError);
        } else {
            order = orderRepository.getById(id);
        }

        return order;
    }

    @Override
    public Order insert(Order o) {
        this.orderRepository.save(o);
        return o;
    }

    @Override
    public void update(int id, Order o) {

    }

    @Override
    public void delete(int id) {
    }
}
