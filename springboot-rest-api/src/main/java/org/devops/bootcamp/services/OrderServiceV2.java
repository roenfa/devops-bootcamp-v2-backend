package org.devops.bootcamp.services;

import org.devops.bootcamp.models.Order;
import org.devops.bootcamp.repositories.OrderRepositoryV2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class OrderServiceV2 {
    @Autowired
    OrderRepositoryV2 orderRepositoryV2;

    public ArrayList<Order> getAllOrders(){
        return (ArrayList<Order>) orderRepositoryV2.findAll();
    }

    public Order saveOrder(Order order){
        return orderRepositoryV2.save(order);
    }

    public Optional<Order> getById(Integer id){
        return orderRepositoryV2.findById(id);
    }

    public boolean deleteProduct(Integer id){
        try{
            orderRepositoryV2.deleteById(id);
            return true;
        }
        catch (Exception e){
            return false;
        }
    }

}
