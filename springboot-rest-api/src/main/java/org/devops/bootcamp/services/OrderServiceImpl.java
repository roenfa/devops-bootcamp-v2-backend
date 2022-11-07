package org.devops.bootcamp.services;

import org.devops.bootcamp.exceptions.NoSuchElementFoundException;
import org.devops.bootcamp.models.Order;
import org.devops.bootcamp.repositories.IOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;


import java.util.List;

@org.springframework.stereotype.Service
public class OrderServiceImpl implements Service<Order> {

    @Autowired
    private IOrderRepository IOrderRepository;


    @Override
    public List<Order> getAll() {
        return IOrderRepository.findAll();
    }

    @Override
    public Order getById(int id) throws NoSuchElementFoundException {
        return IOrderRepository.findById(id).orElseThrow(() -> new NoSuchElementFoundException("Order with id = " + id + " not found!!!"));
    }

    @Override
    public Order insert(Order p) {
        return IOrderRepository.save(p);
    }

    @Override
    public Order update(int id, Order p) {
        return IOrderRepository.save(p);
    }

    @Override
    public void delete(int id) {
         IOrderRepository.deleteById(id);
    }
}
