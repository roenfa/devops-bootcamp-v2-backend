package org.devops.bootcamp.repositories;


import org.devops.bootcamp.models.Order;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public interface OrderRepository extends CrudRepository<Order, Long> {


    // private int status;

    // public int countByStatus(int status) {
    //     return status;
    // }

    // @Query("INSERT INTO orders o")
    // public Order save(Order o) {
    //     orders.add(o);
    //     return o;
    // }

    // public Order getById(int id) {
    //     return orders.stream()
    //             .filter(order -> id == order.getId())
    //             .findAny()
    //             .orElse(null);
    // }

    // public List<Order> getAll() {
    //     return orders;
    // }

    // public Order delete(Order p) {
    //     orders.remove(p);
    //     return p;
    // }

    // public Order update(Order orderToEdit, Order p) {
    //     int orderIndex = orders.indexOf(orderToEdit);
    //     orders.set(orderIndex, p);
    //     return p;
    // }
    
}
