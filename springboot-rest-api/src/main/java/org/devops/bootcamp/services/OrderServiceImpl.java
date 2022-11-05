package org.devops.bootcamp.services;

import java.util.List;
import java.util.ArrayList;

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
    public List<Order> getAll() {
        var it = orderRepository.findAll();
        var orders = new ArrayList<Order>();
        it.forEach(e -> orders.add(e));

        return orders;
    }

    @Override
    public Order getById(Long id) {
        Order o = orderRepository.findById(id).get();
        return o;
    }

    @Override
    public Order insert(Order o) {
        o.setTotal(
            o.getProductList()
            .stream()
            .map(p -> p.getPrice() * p.getAmount())
            .reduce(0.0, (a, b) -> a + b)
        );

        return orderRepository.save(o);
    }

    @Override
    public Order update(Long id, Order o) {
        Order orderToUpdate = orderRepository.findById(id).get();
        Order orderUpdated = null;
        if (orderToUpdate != null) {
            o.setTotal(
                o.getProductList()
                .stream()
                .map(p -> p.getPrice() * p.getAmount())
                .reduce(0.0, (a, b) -> a + b)
            );
            orderUpdated = orderRepository.save(o);
         }

        return orderUpdated;
    }

    @Override
    public Order delete(Long id) {
        Order order = orderRepository.findById(id).get();
        
        if (order != null) {
           orderRepository.delete(order);
        }

        return order;
    }
}
