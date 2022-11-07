package org.devops.bootcamp.models;

// import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
// import lombok.extern.jackson.Jacksonized;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

// @Builder
// @Jacksonized //For lombok-1.18.16
@Getter
@Setter
@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long order_id;

    @NotNull
    @Column(name = "total")
    private double total;
    
    @NotNull
    @Column(name = "client")
    private String client;

    // @JsonIgnore
    @ManyToMany
    @JoinTable(
        name = "order_product",
        joinColumns = @JoinColumn(name="order_id"),
        inverseJoinColumns = @JoinColumn(name="product_id")
    )
    private List<Product> productList = new ArrayList<>();
    // private Product product;

    public Order(){}
    public Order(double total, String client){
        this.total = total;
        this.client = client;
    }

    public long getOrderId(){
        return this.order_id;
    }

    public void setProductsList(Product p){
        productList.add(p);
    }

    public List<Product> getProductsList(){
        return this.productList;
    }

    @Override
    public String toString() {
        return "Order [total = "+getTotal()+ 
        " client = "+ getClient()+
        "]";
    }
    // private List<Product> productList;
}
