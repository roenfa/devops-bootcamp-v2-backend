package org.devops.bootcamp.models;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.jackson.Jacksonized;

@Getter
@Setter
@Builder
@Jacksonized //For lombok-1.18.16
public class Product {
    private int productId;
    private String name;
    private String description;
    private double price;
}

