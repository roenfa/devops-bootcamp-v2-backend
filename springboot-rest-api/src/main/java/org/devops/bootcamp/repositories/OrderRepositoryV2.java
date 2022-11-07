package org.devops.bootcamp.repositories;

import org.devops.bootcamp.models.Order;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepositoryV2 extends CrudRepository<Order,Integer> {
}
