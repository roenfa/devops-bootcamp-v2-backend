package org.devops.bootcamp.models;

// import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
// import lombok.extern.jackson.Jacksonized;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

// @Builder
// @Jacksonized //For lombok-1.18.16
@Getter
@Setter
@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int order_id;

    @NotNull
    @Column(name = "total")
    private double total;
    
    @NotNull
    @Column(name = "client")
    private String client;

    public Order(){}
    public Order(double total, String client){
        this.total = total;
        this.client = client;
    }

    public long getOrderId(){
        return this.order_id;
    }

    @Override
    public String toString() {
        return "Order [total = "+getTotal()+ 
        " client = "+ getClient()+
        "]";
    }
    // private List<Product> productList;
}
