package org.devops.bootcamp.repositories;


import org.devops.bootcamp.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface IProductRepository extends JpaRepository<Product, Integer> {

    //Count by status
    @Query("SELECT p FROM Product p WHERE p.productId = ?1")
    public int countByStatus(int status);
}

