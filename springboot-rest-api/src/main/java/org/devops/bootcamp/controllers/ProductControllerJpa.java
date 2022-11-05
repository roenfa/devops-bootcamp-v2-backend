package org.devops.bootcamp.controllers;

import org.devops.bootcamp.repositories.IProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

// Models
import org.devops.bootcamp.models.Product;

@RestController
@RequestMapping("/api/v2/products")
public class ProductControllerJpa {
    
    @Autowired
    IProductRepository iProductRepository;

    @GetMapping
    public List<Product> getAll(){
        return iProductRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getProduct(@PathVariable("id") long id){
        System.out.println("Long: "+id);
        
        Optional<Product> productData = iProductRepository.findById(id);
        if(productData.isPresent()){
            return new ResponseEntity<>(productData.get(), HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<Product> saveProduct(@RequestBody Product p){
        try{
            Product product = iProductRepository
                .save(new Product(p.getName(), p.getDescription(), p.getPrice()));
            return new ResponseEntity<>(product, HttpStatus.CREATED);
        }catch (Exception exc){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
