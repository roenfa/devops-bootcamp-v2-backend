package org.devops.bootcamp.models;

import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

@Getter
@Setter
@Builder
public class Product {
    private int productId;
    @NonNull
    private String name;
    private String description;
    private double price;
}

