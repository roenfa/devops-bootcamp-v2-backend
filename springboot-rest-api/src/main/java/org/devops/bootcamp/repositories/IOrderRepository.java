package org.devops.bootcamp.repositories;

// import java.util.List;

import org.devops.bootcamp.models.Order;
// import org.devops.bootcamp.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IOrderRepository extends JpaRepository<Order, Long> {
    // public List<Product> getProductsList();
}
