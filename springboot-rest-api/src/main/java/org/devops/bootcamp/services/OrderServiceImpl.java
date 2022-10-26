package org.devops.bootcamp.services;

import java.util.List;

import org.devops.bootcamp.models.Order;
import org.devops.bootcamp.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;

@org.springframework.stereotype.Service
public class OrderServiceImpl implements Service<Order> {

    @Autowired
    OrderRepository orderRepository;

    @Override
    public List<Order> getAll() {
        return orderRepository.getAllOrders();
    }

    @Override
    public Order getById(int id) {
        Order order = null;

        if (orderRepository.getById(id) != null)
            order = orderRepository.getById(id);

        return order;
    }

    @Override
    public Order insert(Order o) {
        orderRepository.save(o);
        return o;
    }

    @Override
    public void update(int id, Order o) {
        // TODO Auto-generated method stub

    }

    @Override
    public void delete(int id) {
        // TODO Auto-generated method stub

    }

}
