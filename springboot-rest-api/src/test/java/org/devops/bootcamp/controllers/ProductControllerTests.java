package org.devops.bootcamp.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;

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
public class ProductControllerTests {
    final String productJsonString = "{\"name\":\"Oreo\",\"description\":\"cookies\",\"price\":3.5}";

    @MockBean
    private Service<Product> productService;

    @Autowired
    ObjectMapper objectMapper;

    @Autowired
    private MockMvc mockMvc;

    private final Long id = 1L;

    @BeforeEach
    public void setUp() {
        given(this.productService.getAll())
                .willReturn(
                        Arrays.asList(
                                Product.builder().id(id).name("oreo").description("cookies").price(3.5).build(),
                                Product.builder().id(id).name("milk").description("drink").price(6.5).build()
                        ));

        given(this.productService.insert(any(Product.class)))
                .willReturn(Product.builder().id(id).name("oreo").description("cookies").price(3.5).build());

    }

    @Test
    @WithMockUser
    public void createProduct() throws Exception {
        Product productMock = Product.builder()
                .id(id)
                .name("Oreo")
                .description("cookies")
                .price(3.5).build();

        // productService.insert to respond back with productMock
        Mockito.when(productService.insert(any(Product.class))).thenReturn(productMock);

        RequestBuilder requestBuilder = post(
                "/api/v1/products")
                .accept(MediaType.APPLICATION_JSON).content(productJsonString)
                .contentType(MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(requestBuilder).andReturn();

        MockHttpServletResponse response = result.getResponse();

        assertEquals(HttpStatus.CREATED.value(), response.getStatus());

        assertEquals("/api/v1/products/1", response.getHeader("product"));
    }

    @Test
    @WithMockUser
    public void testSave() throws Exception {

        this.mockMvc
                .perform(
                        post("/api/v1/products")
                                .content(this.objectMapper.writeValueAsBytes(
                                        Product.builder()
                                                .name("oreo").description("cookies").price(3.5).build()))
                                .contentType(MediaType.APPLICATION_JSON)
                )
                .andExpect(status().isCreated());

        verify(this.productService, times(1)).insert(any(Product.class));
        verifyNoMoreInteractions(this.productService);
    }
}
