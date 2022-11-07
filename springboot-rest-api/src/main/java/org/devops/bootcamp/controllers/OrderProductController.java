package org.devops.bootcamp.controllers;

import org.devops.bootcamp.models.OrderProduct;
import org.devops.bootcamp.services.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/orders_products")
public class OrderProductController {

    @Autowired
    private Service<OrderProduct> orderProductService;

    @GetMapping()
    public List<OrderProduct> getAll() {
        return orderProductService.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrderProduct> getOrderProduct(@PathVariable("id") Integer id) {
        OrderProduct orderProduct = orderProductService.getById(id);
        return ResponseEntity.ok(orderProduct);
    }

    @PostMapping
    public ResponseEntity<OrderProduct> saveOrderProduct(@RequestBody OrderProduct op) {
         orderProductService.insert(op);
        return ResponseEntity.ok(op);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteOrderProduct(@PathVariable("id") Integer id) {
        orderProductService.delete(id);
        return ResponseEntity.ok().build();
    }
}
