package org.devops.bootcamp.repositories;

import org.devops.bootcamp.models.OrderProduct;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IOrderProductRepository extends JpaRepository<OrderProduct, Integer> {
}
