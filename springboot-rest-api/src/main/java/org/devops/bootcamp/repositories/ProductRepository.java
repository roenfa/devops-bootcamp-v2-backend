package org.devops.bootcamp.repositories;

import org.devops.bootcamp.models.Product;

public interface ProductRepository extends Repository<Product, Integer>{
    int countByStatus(int status);

}
