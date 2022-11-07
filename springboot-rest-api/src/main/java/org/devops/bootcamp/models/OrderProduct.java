package org.devops.bootcamp.models;


import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "order_product")
@JsonIgnoreProperties(value= {"suppliers"})
public class OrderProduct extends AbstractEntity {
    
    @ManyToOne
    private Product product;

    @Column(nullable = false)
    private Double price;
    private int amount;
}
