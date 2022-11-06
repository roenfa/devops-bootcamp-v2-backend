package org.devops.bootcamp.controllers;

import org.devops.bootcamp.services_jpa.ProductServiceJpa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

// Models
import org.devops.bootcamp.models.Product;

@RestController
@RequestMapping("/api/v2/products")
public class ProductControllerJpa {
    
    // @Autowired
    // IProductRepository iProductRepository;

    @Autowired
    ProductServiceJpa productServiceJpa;

    @GetMapping
    public List<Product> getAll(){
        return productServiceJpa.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getProduct(@PathVariable("id") long id){
        Product product = productServiceJpa.getById(id);
        return new ResponseEntity<>(product, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Product> saveProduct(@RequestBody Product p){
        try{
            Product product = productServiceJpa.save(p);
            return new ResponseEntity<>(product, HttpStatus.CREATED);
        }catch (Exception exc){
            System.out.println(exc.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable("id") long id, @RequestBody Product p){
        Product product = productServiceJpa.getById(id);
        product.setName(p.getName());
        product.setDescription(p.getDescription());
        product.setPrice(p.getPrice());
        return new ResponseEntity<>(productServiceJpa.save(product), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Product> deleteProduct(@PathVariable("id") long id){
        try{
            productServiceJpa.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }catch(Exception exc){
            System.out.println(exc.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
