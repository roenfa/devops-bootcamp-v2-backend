package org.devops.bootcamp.repositories;


import org.devops.bootcamp.models.Product;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;
import java.util.List;

@Repository
public interface ProductRepository extends CrudRepository<Product, Long> {

    // int status = 0;

    // // private List<Product> products = new ArrayList<Product>();

    // public int countByStatus(int status) {
    //     return status;
    // }

    // public Product save(Product p) {
    //     products.add(p);
    //     return p;
    // }

    // public Product getById(int id) {
    //     return products.stream()
    //             .filter(product -> id == product.getId())
    //             .findAny()
    //             .orElse(null);
    // }

    // public List<Product> getAllProducts() {
    //     return products;
    // }

    // public Product delete(Product p) {
    //     products.remove(p);
    //     return p;
    // }

    // public Product update(Product productToEdit, Product p) {
    //     int productIndex = products.indexOf(productToEdit);
    //     products.set(productIndex, p);
    //     return p;
    // }

}

