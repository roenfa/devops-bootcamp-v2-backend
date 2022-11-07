package org.devops.bootcamp.services;

import org.devops.bootcamp.models.Product;
import org.devops.bootcamp.repositories.ProductRepositoryV2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;
@Service
public class ProductServiceV2 {

    @Autowired
    ProductRepositoryV2 productRepositoryV2;

    public ArrayList<Product> getAllProducts(){
        return (ArrayList<Product>) productRepositoryV2.findAll();
    }

    public Product saveProduct(Product product){
        return productRepositoryV2.save(product);
    }

    public Optional<Product> getById(Integer id){
        return productRepositoryV2.findById(id);
    }

    public boolean deleteProduct(Integer id){
        try{
            productRepositoryV2.deleteById(id);
            return true;
        }
        catch (Exception e){
            return false;
        }
    }



}
