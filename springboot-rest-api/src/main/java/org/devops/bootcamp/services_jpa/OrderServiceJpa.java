package org.devops.bootcamp.services_jpa;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.devops.bootcamp.exceptions.InternalServerErrorException;
import org.devops.bootcamp.models.Order;
import org.devops.bootcamp.models.Product;
import org.devops.bootcamp.repositories.IOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceJpa implements ServiceJpa<Order> {
    
    @Autowired
    IOrderRepository iOrderRepository;

    @Override
    public List<Order> findAll() {
        return iOrderRepository.findAll();
    }

    @Override
    public Order getById(long id) throws NoSuchElementException {
        Optional<Order> orderData = iOrderRepository.findById(id);

        if(orderData.isPresent()){
            return orderData.get();
        }else{
            String messageError = "Order with id = " + id + " not found!!!";

            throw new NoSuchElementException(messageError);
        }
    }

    @Override
    public Order save(Order s) {
        return iOrderRepository.save(
            new Order(s.getTotal(), s.getClient())
        );
    }

    @Override
    public void deleteById(long id) throws InternalServerErrorException {
        try {
            iOrderRepository.deleteById(id);
        } catch (Exception e) {
            String messageError = "Order couldn't be deleted!";

            throw new InternalServerErrorException(messageError);
        }
    }

    public List<Product> getProductsFromOrder(long id){
        Order order = this.getById(id);
        return order.getProductsList();
    }
}
