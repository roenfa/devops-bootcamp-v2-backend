package org.devops.bootcamp.services;


import org.devops.bootcamp.models.Product;
import org.devops.bootcamp.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@org.springframework.stereotype.Service
public class ProductServiceImpl implements Service<Product> {
    @Autowired
    ProductRepository productRepository;

//    public ProductServiceImpl(ProductRepository productRepository) {
//        this.productRepository = productRepository;
//    }

    @Override
    public List getAll() {
        return productRepository.getAllProducts();
    }

    @Override
    public Product getById(int id) {
        Product product = null;
        
        if (productRepository.getById(id) != null) {
           product = productRepository.getById(id);
        }

        return product;
    }

    @Override
    public Product insert(Product p) {
        return productRepository.save(p);
    }

    @Override
    public Product update(int id, Product p) {
        Product productToUpdate = productRepository.getById(id);
        Product productUpdated = null;
        if (productToUpdate != null) {
            productUpdated = productRepository.update(productToUpdate, p);
         }

        return productUpdated;
    }

    @Override
    public Product delete(int id) {
        Product product = productRepository.getById(id);
        
        if (product != null) {
           product = productRepository.delete(product);
        }

        return product;
    }
}