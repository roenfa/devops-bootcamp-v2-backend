package org.devops.bootcamp.models;

import lombok.Builder;
import lombok.Getter;
// import lombok.NonNull;
import lombok.Setter;
import lombok.extern.jackson.Jacksonized;

// import javax.validation.constraints.NotBlank;
// import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@Builder
@Jacksonized //For lombok-1.18.16
public class Product {
    private int productId;
    @NotNull
    private String name;
    private String description;
    private double price;
}

