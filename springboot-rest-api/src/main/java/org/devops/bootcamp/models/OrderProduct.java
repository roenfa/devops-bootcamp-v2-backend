package org.devops.bootcamp.models;

import java.math.BigDecimal;

import javax.persistence.*;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "order_product")
public class OrderProduct extends AbstractEntity {
    @ManyToOne
    private Product product;

    @Column(nullable = false)
    private Double price;
    private int amount;
}
