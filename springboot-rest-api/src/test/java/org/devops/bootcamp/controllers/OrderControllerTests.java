package org.devops.bootcamp.controllers;


import org.devops.bootcamp.models.Product;
import org.devops.bootcamp.services.OrderService;
import org.devops.bootcamp.services.ProductService;
import org.json.JSONObject;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
@AutoConfigureMockMvc(addFilters = false)
public class OrderControllerTests {

    private MockMvc mockMvc;
    private OrderService orderService;
    private ProductService productService;

    @Autowired
    public OrderControllerTests(MockMvc mockMvc, OrderService orderService, ProductService productService) {
        this.mockMvc = mockMvc;
        this.orderService = orderService;
        this.productService = productService;
    }

    @BeforeEach
    public void setUp(){
        this.productService.insert(
                Product.builder()
                        .productId(20)
                        .name("bread")
                        .description("glutten free")
                        .price(700)
                        .build()
        );
    }


    @Test
    public void createNewOrder() throws Exception {

        JSONObject requestProduct = new JSONObject();
        requestProduct.put("productId", 20);

        JSONObject requestBody = new JSONObject();
        requestBody.put("client", "anonymous");
        requestBody.put("productList", JSONObject.wrap(List.of(requestProduct)));

        System.out.println(requestBody.toString());

        this.mockMvc.perform(
                MockMvcRequestBuilders
                        .post("/api/v1/orders")
                        .content(requestBody.toString())
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON)
        ).andExpect(MockMvcResultMatchers.status().isCreated())
                .andExpect(MockMvcResultMatchers.header().exists("location"));

    }

}
