package org.devops.bootcamp.services_jpa;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.devops.bootcamp.exceptions.NoSuchElementFoundException;
import org.devops.bootcamp.models.Product;
import org.devops.bootcamp.repositories.IProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceJpa implements ServiceJpa<Product> {
    
    @Autowired
    private IProductRepository iProductRepository;

    @Override
    public List<Product> findAll() {
        return iProductRepository.findAll();
    }

    @Override
    public Product getById(long id) throws NoSuchElementException {
        Optional<Product> productData = iProductRepository.findById(id);

        if(productData.isPresent()){
            return productData.get();
        }else{
            String messageError = "Product with id = " + id + " not found!!!";

            throw new NoSuchElementFoundException(messageError);
        }
    }

    @Override
    public Product save(Product s) {
        return iProductRepository.save(
            new Product(s.getName(), s.getDescription(), s.getPrice())
        );
    }

    @Override
    public void deleteById(long id) {
        iProductRepository.deleteById(id);
    }
}
