package org.devops.bootcamp.models;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Builder
public class Order {
    private int orderId;
    private double total;
    private String client;
    private List<Product> productList;
}
