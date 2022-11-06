package org.devops.bootcamp.models;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table( name = "PRODUCT_ORDER")
public class Order {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Integer orderId;

    private double total;
    private String client;

    @OneToMany(mappedBy = "productId", fetch = FetchType.EAGER)
    private List<Product> productList;

}
