package org.devops.bootcamp.repositories;

import org.devops.bootcamp.models.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;


@Repository
public class OrderRepositoryImpl implements OrderRepository {

    private EntityManager entityManager;

    @Autowired
    public OrderRepositoryImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public Order save(Order entity) {
        return this.entityManager.merge(entity);
    }

    @Override
    @Transactional
    public Order delete(Order entity) {
        this.entityManager.remove(entityManager.contains(entity) ? entity : entityManager.merge(entity));
        return entity;
    }

    @Override
    public List<Order> getAll() {
        return entityManager.createQuery("SELECT o FROM Order o", Order.class).getResultList();
    }

    @Override
    public Order getById(Integer entityId) {
        return this.entityManager.find(Order.class, entityId);
    }

}
