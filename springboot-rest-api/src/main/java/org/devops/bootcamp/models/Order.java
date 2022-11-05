package org.devops.bootcamp.models;

import java.util.List;
import java.util.Set;

import javax.persistence.*;

import lombok.*;


@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "orders")
public class Order extends AbstractEntity {

    private String client;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "order_id")
    private Set<OrderProduct> productList;

    private Double total;
}
