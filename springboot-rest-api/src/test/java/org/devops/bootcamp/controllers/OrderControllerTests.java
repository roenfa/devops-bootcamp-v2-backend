package org.devops.bootcamp.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;

import org.devops.bootcamp.models.Order;
import org.devops.bootcamp.models.OrderProduct;
import org.devops.bootcamp.models.Product;
import org.devops.bootcamp.services.Service;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.*;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.*;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import static org.mockito.Mockito.*;


@SpringBootTest
@AutoConfigureMockMvc
public class OrderControllerTests {
    final String orderJsonString = "{\"productList\":[{\"product\":{\"id\":1,\"name\":\"Zanahoria\",\"description\":\"De la tierra\",\"price\":5.0},\"price\":5.0,\"amount\":3},{\"product\":{\"id\":2,\"name\":\"Papa\",\"description\":\"De la luz\",\"price\":3.0},\"price\": 3.0,\"amount\":4}],\"client\":\"Camilo\"}";

    @MockBean
    private Service<Order> orderService;

    @Autowired
    ObjectMapper objectMapper;

    @Autowired
    private MockMvc mockMvc;

    private final Long idOrder = 1L;

    private final Long idOrderProduct = 1L;

    private final Long idProduct = 1L;

    private Product productBuilder(Long productId, String name, String description, Double price){
        return Product.builder()
        .id(idProduct)
        .name(name)
        .description(description)
        .price(price).build();
    }

    private Order orderBuilder(String client, Long orderId) {
        return Order.builder()
        .id(orderId)
        .client(client)
        .productList(
            Arrays.asList(
                OrderProduct.builder()
                    .id(idOrderProduct)
                    .product(productBuilder(1L, "Zanahoria", "Sergio", 5.0))
                    .price(5.0)
                    .amount(3).build(),
                OrderProduct.builder()
                    .id(idOrderProduct + 1)
                    .product(productBuilder(2L, "Papa", "Sergio", 3.0))
                    .price(3.0)
                    .amount(4).build()
            )
        )
        .total(27.0).build();
    }

    @BeforeEach
    public void setUp() {
        given(this.orderService.getAll())
                .willReturn(Arrays.asList(
                    orderBuilder("Sergio", idOrder),
                    orderBuilder("Camilo", idOrder + 1)
                ));

        given(this.orderService.insert(any(Order.class)))
                .willReturn(orderBuilder(orderJsonString, idOrder));

    }

    @Test
    @WithMockUser
    public void createOrder() throws Exception {
        Order orderMock = orderBuilder("Sergio", idOrder);

        // orderService.insert to respond back with OrderMock
        Mockito.when(orderService.insert(any(Order.class))).thenReturn(orderMock);

        RequestBuilder requestBuilder = post(
                "/api/v1/order")
                .accept(MediaType.APPLICATION_JSON).content(orderJsonString)
                .contentType(MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(requestBuilder).andReturn();

        MockHttpServletResponse response = result.getResponse();

        assertEquals(HttpStatus.CREATED.value(), response.getStatus());

        assertEquals("/api/v1/order/1", response.getHeader("Order"));
    }

    @Test
    @WithMockUser
    public void testSave() throws Exception {

        this.mockMvc
                .perform(
                        post("/api/v1/order")
                                .content(this.objectMapper.writeValueAsBytes(orderBuilder("Sergio", idOrder)))
                                .contentType(MediaType.APPLICATION_JSON)
                )
                .andExpect(status().isCreated());

        verify(this.orderService, times(1)).insert(any(Order.class));
        verifyNoMoreInteractions(this.orderService);
    }
}


