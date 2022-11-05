package org.devops.bootcamp.services;


import org.devops.bootcamp.exceptions.NoSuchElementFoundException;
import org.devops.bootcamp.models.Product;
import org.devops.bootcamp.repositories.ProductRepository;
// import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.ArrayList;

@org.springframework.stereotype.Service
public class ProductServiceImpl implements Service<Product> {
//    @Autowired -> @InjectMock
//    ProductRepository productRepository;
    private ProductRepository productRepository;
    public ProductServiceImpl(ProductRepository repository) {
        this.productRepository = repository;
    }

//    public ProductServiceImpl(ProductRepository productRepository) {
//        this.productRepository = productRepository;
//    }

    @Override
    public List<Product> getAll() {
        var it = productRepository.findAll();
        var orders = new ArrayList<Product>();
        it.forEach(e -> orders.add(e));

        return orders;
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
    public Product getById(Long id) throws NoSuchElementFoundException {
        Product product = null;

        var messageError = "Product with id = " + id + " not found!!!";

        if (productRepository.findById(id) == null) {
            throw new NoSuchElementFoundException(messageError);
        } else {
            product = productRepository.findById(id).get();
        }

        return product;
    }

    @Override
    public Product insert(Product p) {
        this.productRepository.save(p);
        return p;
    }

    @Override
    public Product update(Long id, Product p) {
        Product productToUpdate = productRepository.findById(id).get();
        Product productUpdated = null;
        if (productToUpdate != null) {
            productUpdated = productRepository.save(p);
         }

        return productUpdated;
    }

    @Override
    public Product delete(Long id) {
        Product product = productRepository.findById(id).get();
        
        if (product != null) {
           productRepository.delete(product);
        }

        return product;
    }
}