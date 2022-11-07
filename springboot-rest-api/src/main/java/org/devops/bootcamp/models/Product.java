package org.devops.bootcamp.models;

import javax.persistence.*;

import lombok.*;


// import javax.validation.constraints.NotBlank;
// import javax.validation.constraints.NotEmpty;
// import javax.validation.constraints.NotNull;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "products")
public class Product extends AbstractEntity {

    private Long id = super.getId();
    
    @Column(nullable = false)
    private String name;
    private String description;

    @Column(nullable = false)  
    private Double price;
}