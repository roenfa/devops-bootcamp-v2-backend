package org.devops.bootcamp.models;

// import lombok.Builder;
import lombok.Getter;
// import lombok.NonNull;
import lombok.Setter;
// import lombok.extern.jackson.Jacksonized;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
// import javax.validation.constraints.NotBlank;
// import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Getter
@Setter
// @Builder
// @Jacksonized //For lombok-1.18.16
@Entity
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private long product_id;
    
    @NotNull
    @Column(name = "name")
    private String name;
    
    @Column(name = "description")
    private String description;
    
    @NotNull
    @Column(name = "price")
    private double price;

    @ManyToMany(mappedBy = "productList")
    private List<Order> orderList = new ArrayList<>();

    public Product(){}

    public Product(String name, String description, double price){
        this.name = name;
        this.description = description;
        this.price = price;
    }

    public long getProductId(){
        return this.product_id;
    }

    @Override
    public String toString() {
        return "Product [name = "+getName()+ 
        " description = "+ getDescription()+
        " price = "+getPrice()+
        "]";
        // return super.toString();
    }
}

