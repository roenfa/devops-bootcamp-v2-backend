package org.devops.bootcamp.services;


import org.devops.bootcamp.exceptions.NoSuchElementFoundException;
import org.devops.bootcamp.models.Product;
import org.devops.bootcamp.repositories.IProductRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@org.springframework.stereotype.Service
public class ProductServiceImpl implements Service<Product> {

    @Autowired
    private IProductRepository productRepository;

    @Override
    public List getAll() {
        return productRepository.findAll();
    }

    //    @Override
//    public Product getById(int id) {
//        Product product = null;
//
//        if (productRepository.getById(id) != null) {
//           product = productRepository.getById(id);
//        }
//
//        return product;
//    }
    @Override
    public Product getById(int id) throws NoSuchElementFoundException {
        return productRepository.findById(id).orElseThrow(() -> new NoSuchElementFoundException("Product with id = " + id + " not found!!!"));
    }

    @Override
    public Product insert(Product p) {
        productRepository.save(p);
        return p;
    }

    @Override
    public Product update(int id, Product p) {
        return null;
    }

    @Override
    public void delete(int id) {
    }
}