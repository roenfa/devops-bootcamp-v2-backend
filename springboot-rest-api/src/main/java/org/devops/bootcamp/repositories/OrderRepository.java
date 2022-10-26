package org.devops.bootcamp.repositories;

import org.devops.bootcamp.models.Order;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
@Repository
public class OrderRepository {

    private List<Order> orders = new ArrayList<Order>();

    public Order save(Order o){
        orders.add(o);
        return o;
    }

    public Order getById(int id){
        return orders.stream()
                .filter(order -> id == order.getOrderId())
                .findAny()
                .orElse(null);
    }

    public List<Order> getAllOrders(){return orders;}
}
