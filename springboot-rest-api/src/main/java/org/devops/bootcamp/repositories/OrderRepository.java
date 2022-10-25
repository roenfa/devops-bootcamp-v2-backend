package org.devops.bootcamp.repositories;


import org.devops.bootcamp.models.Order;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class OrderRepository {

    private int status;

    private List<Order> orders = new ArrayList<Order>();

    public int countByStatus(int status) {
        return status;
    }

    public Order save(Order p) {
        orders.add(p);
        return p;
    }

    public Order getById(int id) {
        return orders.stream()
                .filter(order -> id == order.getOrderId())
                .findAny()
                .orElse(null);
    }

    public List<Order> getAll() {
        return orders;
    }

    public Order delete(Order p) {
        orders.remove(p);
        return p;
    }

    public Order update(Order orderToEdit, Order p) {
        int orderIndex = orders.indexOf(orderToEdit);
        orders.set(orderIndex, p);
        return p;
    }

}
