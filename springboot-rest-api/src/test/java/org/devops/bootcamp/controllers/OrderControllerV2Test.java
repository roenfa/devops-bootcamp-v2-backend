package org.devops.bootcamp.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.devops.bootcamp.models.Order;
import org.devops.bootcamp.models.Product;
import org.devops.bootcamp.services.Service;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.autoconfigure.security.servlet.UserDetailsServiceAutoConfiguration;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(
        controllers = ProductController.class,
        excludeAutoConfiguration = {
                UserDetailsServiceAutoConfiguration.class, SecurityAutoConfiguration.class
        }
)
class OrderControllerV2Test {

    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private Service<Order> orderService;
    @Autowired
    ObjectMapper objectMapper;

    @BeforeEach
    public void setUp() {
        given(this.orderService.getAll())
                .willReturn(
                        Arrays.asList(
                                Order.builder()
                                        .orderId(1)
                                        .client("juan")
                                        .total(0)
                                        .build()
                        ));

        given(this.orderService.insert(any(Order.class)))
                .willReturn(Order.builder().orderId(1).client("Juan").total(0).build());
        doNothing().when(this.orderService).delete(any(Integer.class));
    }
    @Test
    void saveOrder() throws Exception {

        this.mockMvc
                .perform(
                        post("/api/v2/orders")
                                .content(this.objectMapper.writeValueAsBytes(
                                        Order.builder()
                                                .orderId(1)
                                                .client("Juan")
                                                .total(0).build()))
                                .contentType(MediaType.APPLICATION_JSON)
                )
                .andExpect(status().isCreated());

        verify(this.orderService, times(1)).insert(any(Order.class));
        verifyNoMoreInteractions(this.orderService);
    }
}