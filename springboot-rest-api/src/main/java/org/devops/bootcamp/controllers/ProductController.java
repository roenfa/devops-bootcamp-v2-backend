package org.devops.bootcamp.controllers;

import org.devops.bootcamp.models.Product;
import org.devops.bootcamp.services.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/product")
public class ProductController {
    @Autowired
    private Service<Product> productService;

//    public ProductController(Service productService) {
//        this.productService = productService;
//    }

    @GetMapping
    public List<Product> getAll() {
        return productService.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getProduct(@PathVariable("id") Long id) {
        Product product = productService.getById(id);
        return new ResponseEntity<>(product, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Product> saveProduct(@RequestBody Product p) {
        Product product = productService.insert(p);
        var httpHeaders = new HttpHeaders();
        httpHeaders.add("product", "/api/v1/product/" + product.getId());
        return new ResponseEntity<>(product, httpHeaders, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Product> deleteProduct(@PathVariable("id") Long id) {
        Product product = productService.delete(id);
        return new ResponseEntity<>(product, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable("id") Long id, @RequestBody Product p){
        Product product = productService.update(id, p);
        var httpHeaders = new HttpHeaders();
        httpHeaders.add("product", "/api/v1/product/" + product.getId());
        return new ResponseEntity<>(product, httpHeaders, HttpStatus.CREATED);
    }
}