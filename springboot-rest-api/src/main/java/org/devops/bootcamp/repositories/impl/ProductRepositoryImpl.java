package org.devops.bootcamp.repositories.impl;


import org.devops.bootcamp.models.Product;
import org.devops.bootcamp.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class ProductRepositoryImpl implements ProductRepository {

    private EntityManager entityManager;

    @Autowired
    public ProductRepositoryImpl(EntityManager entityManager){
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public Product save(Product p) {
        p = this.entityManager.merge(p);
        return p;
    }

    @Override
    @Transactional
    public Product delete(Product entity) {
        this.entityManager.remove(entityManager.contains(entity) ? entity : entityManager.merge(entity));
        return entity;
    }

    @Override
    public List<Product> getAll() {
        return entityManager.createQuery("SELECT p FROM Product p", Product.class).getResultList();
    }

    @Override
    public Product getById(Integer entityId) {
        return this.entityManager.find(Product.class, entityId);
    }

    @Override
    public int countByStatus(int status) {
        return status;
    }

}

