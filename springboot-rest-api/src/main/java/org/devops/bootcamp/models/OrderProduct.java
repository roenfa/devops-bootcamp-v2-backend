package org.devops.bootcamp.models;


import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@JsonIgnoreProperties(value= {"suppliers"})
@Table(name = "order_product")
public class OrderProduct extends AbstractEntity {
    @ManyToOne
    private Product product;

    @Column(nullable = false)
    private Double price;
    private int amount;
}
