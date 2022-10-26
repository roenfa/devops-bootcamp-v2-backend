package org.devops.bootcamp.services;

import java.util.List;

import org.devops.bootcamp.models.Order;
import org.devops.bootcamp.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;

@org.springframework.stereotype.Service
public class OrderServiceImpl implements Service<Order> {
    @Autowired
    OrderRepository orderRepository;

//    public OrderServiceImpl(OrderRepository OrderRepository) {
//        this.OrderRepository = OrderRepository;
//    }

    @Override
    public List getAll() {
        return orderRepository.getAll();
    }

    @Override
    public Order getById(int id) {
        Order Order = null;
        
        if (orderRepository.getById(id) != null) {
           Order = orderRepository.getById(id);
        }

        return Order;
    }

    @Override
    public Order insert(Order o) {
        o.setTotal(
            o.getProductList()
            .stream()
            .map(p -> p.getPrice())
            .reduce(0.0, (a, b) -> a + b)
        );

        return orderRepository.save(o);
    }

    @Override
    public Order update(int id, Order o) {
        Order orderToUpdate = orderRepository.getById(id);
        Order orderUpdated = null;
        if (orderToUpdate != null) {
            o.setTotal(
                o.getProductList()
                .stream()
                .map(p -> p.getPrice())
                .reduce(0.0, (a, b) -> a + b)
            );
            orderUpdated = orderRepository.update(orderToUpdate, o);
         }

        return orderUpdated;
    }

    @Override
    public Order delete(int id) {
        Order order = orderRepository.getById(id);
        
        if (order != null) {
           order = orderRepository.delete(order);
        }

        return order;
    }
}
