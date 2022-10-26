package org.devops.bootcamp.models;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.jackson.Jacksonized;

import java.util.List;

@Getter
@Setter
@Builder
@Jacksonized //For lombok-1.18.16
public class Order {
    private int orderId;
    private double total;
    private String client;
    private List<Product> productList;
}
