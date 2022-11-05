package org.devops.bootcamp.repositories;

import org.devops.bootcamp.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IProductRepository extends JpaRepository<Product, Long>{
}
