package org.devops.bootcamp.controllers;

import org.devops.bootcamp.models.Product;
import org.devops.bootcamp.services.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/products")
public class ProductController {
    @Autowired
    private Service<Product> productService;


    @GetMapping
    public List<Product> getAll() {
        return productService.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getProduct(@PathVariable("id") Integer id) {
        Product product = productService.getById(id);
        return new ResponseEntity<>(product, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Product> saveProduct(@Valid @RequestBody Product p) {
        Product product = productService.insert(p);
        var httpHeaders = new HttpHeaders();
        httpHeaders.add("product", "/api/v1/products/" + product.getProductId());
        return new ResponseEntity<>(product, httpHeaders, HttpStatus.CREATED);
    }

}