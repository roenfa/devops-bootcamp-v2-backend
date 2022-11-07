package org.devops.bootcamp.controllers;

import org.devops.bootcamp.models.Product;
import org.devops.bootcamp.services.ProductServiceV2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping("/api/v2/products")
public class ProductControllerV2 {
    @Autowired
    ProductServiceV2 productServiceV2;

    @GetMapping
    public ArrayList<Product> getAll(){
        return productServiceV2.getAllProducts();
    }

    @PostMapping
    public Product saveProduct(@RequestBody Product product){
        return productServiceV2.saveProduct(product);
    }

    @GetMapping(path = "/{id}")
    public Optional<Product> getProductById(@PathVariable("id") Integer id){
        return productServiceV2.getById(id);
    }

    @DeleteMapping(path = "/{id}")
    public String deleteProduct(@PathVariable("id") Integer id){
        boolean ok = productServiceV2.deleteProduct(id);
        if(ok){
            return "Product deleted";
        }
        else{
            return "Product not found";
        }
    }
}
