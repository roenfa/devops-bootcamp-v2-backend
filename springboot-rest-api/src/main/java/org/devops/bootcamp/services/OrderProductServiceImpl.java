package org.devops.bootcamp.services;

import org.devops.bootcamp.models.Order;
import org.devops.bootcamp.models.OrderProduct;
import org.devops.bootcamp.models.Product;
import org.devops.bootcamp.exceptions.NoSuchElementFoundException;
import org.devops.bootcamp.repositories.IOrderProductRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@org.springframework.stereotype.Service
public class OrderProductServiceImpl implements Service<OrderProduct>{

    @Autowired
    private IOrderProductRepository orderProductRepository;

    @Autowired
    private Service<Order> orderService;

    @Autowired
    private Service<Product> productService;

    @Override
    public List<OrderProduct> getAll() {
        return orderProductRepository.findAll();
    }

    @Override
    public OrderProduct getById(int id) throws NoSuchElementFoundException {
        return orderProductRepository.findById(id).orElseThrow(() -> new NoSuchElementFoundException("OrderProduct with id = " + id + " not found!!!"));
    }

    @Override
    public OrderProduct insert(OrderProduct p) {
        try {
            var product = productService.getById(p.getProductId());
            var order = orderService.getById(p.getOrderId());
            order.setTotal(order.getTotal() + (product.getPrice() * p.getQuantity()));
            orderService.insert(order);
            return  orderProductRepository.save(p);
        } catch (NoSuchElementFoundException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public OrderProduct update(int id, OrderProduct p) {
        return orderProductRepository.save(p);
    }

    @Override
    public void delete(int id) {

    }
}
