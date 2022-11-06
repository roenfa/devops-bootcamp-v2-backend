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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer orderId;

    @Getter(AccessLevel.NONE)
    private double total;

    private String client;

    @ManyToMany(cascade = CascadeType.REFRESH, fetch = FetchType.EAGER)
    private List<Product> productList;

    public double getTotal() {
        return this.productList.stream().reduce(0.0, (acc, product) -> acc + product.getPrice(), Double::sum);
    }
}
