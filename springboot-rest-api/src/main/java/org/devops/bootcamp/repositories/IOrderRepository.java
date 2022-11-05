package org.devops.bootcamp.repositories;

import org.devops.bootcamp.models.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IOrderRepository extends JpaRepository<Order, Long> {
    
}
