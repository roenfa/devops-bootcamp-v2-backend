package org.devops.bootcamp.models;

import java.math.BigDecimal;

import javax.persistence.*;

import lombok.*;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "products")
public class Product extends AbstractEntity {
    
    @Column(nullable = false)
    private String name;
    private String description;

    @Column(nullable = false)  
    private Double price;
}

