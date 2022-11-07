package org.devops.bootcamp.repositories;

import org.devops.bootcamp.models.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface IOrderRepository extends JpaRepository<Order, Integer> {

    //Update
    @Query("UPDATE Order o SET o.client = ?1, o.total = ?2 WHERE o.orderId = ?3")
    Order update(String client, double total, int id);
}

