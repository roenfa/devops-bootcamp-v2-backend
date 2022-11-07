package org.devops.bootcamp.repositories;

import org.devops.bootcamp.models.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepositoryV2 extends CrudRepository <Product,Integer> {
}
