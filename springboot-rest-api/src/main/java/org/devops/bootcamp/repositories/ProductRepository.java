package org.devops.bootcamp.repositories;


import org.devops.bootcamp.models.Product;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductRepository {

    private int status;

    private List<Product> products = new ArrayList<Product>();
    // dependencia con el servicio urlShortener -> obtener el link de la imagen de mi producto
    // database connection mysql -> connection up or not?

    public int countByStatus(int status) {
        return status;
    }

    public Product save(Product p) {
        products.add(p);
        return p;
    }

    public Product getById(int id) {
        return products.stream()
                .filter(product -> id == product.getProductId())
                .findAny()
                .orElse(null);
    }

    public List<Product> getAllProducts() {
        return products;
    }

}

