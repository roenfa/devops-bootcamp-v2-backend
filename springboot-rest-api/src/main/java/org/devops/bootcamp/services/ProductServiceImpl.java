package org.devops.bootcamp.services;


import org.devops.bootcamp.exceptions.NoSuchElementFoundException;
import org.devops.bootcamp.models.Product;
import org.devops.bootcamp.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

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
    public List getAll() {
        return productRepository.getAllProducts();
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
        Product product = null;

        String messageError = "Product with id = " + id + " not found!!!";

        if (productRepository.getById(id) == null) {
            throw new NoSuchElementFoundException(messageError);
        } else {
            product = productRepository.getById(id);
        }

        return product;
    }

    @Override
    public Product insert(Product p) {
        this.productRepository.save(p);
        return p;
    }

    @Override
    public void update(int id, Product p) {

    }

    @Override
    public void delete(int id) {
    }
}