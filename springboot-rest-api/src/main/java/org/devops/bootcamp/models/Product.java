package org.devops.bootcamp.models;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class Product {
    private int productId;
    private String name;
    private String description;
    private double price;
}

