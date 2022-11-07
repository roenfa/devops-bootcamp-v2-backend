package org.devops.bootcamp.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.devops.bootcamp.models.Product;
import org.devops.bootcamp.services.Service;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.autoconfigure.security.servlet.UserDetailsServiceAutoConfiguration;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;

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
class ProductControllerV2Test {
    final String productJsonString = "{\"id\":1,\"name\":\"Shampoo\",\"description\":\"body cleaning\",\"price\":10}";
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private Service<Product> productService;
    @Autowired
    ObjectMapper objectMapper;

    @BeforeEach
    public void setUp() {
        given(this.productService.getAll())
                .willReturn(
                        Arrays.asList(
                                Product.builder().productId(1).name("oreo").description("cookies").price(3.5).build(),
                                Product.builder().productId(2).name("milk").description("drink").price(6.5).build()
                        ));

        given(this.productService.insert(any(Product.class)))
                .willReturn(Product.builder().productId(1).name("oreo").description("cookies").price(3.5).build());

        doNothing().when(this.productService).delete(any(Integer.class));
    }
    @Test
    public void createProduct() throws Exception {
        Product productMock = Product.builder()
                .productId(0)
                .name("Oreo")
                .description("cookies")
                .price(3.5).build();

        // productService.insert to respond back with productMock
        Mockito.when(productService.insert(any(Product.class))).thenReturn(productMock);

        RequestBuilder requestBuilder = post(
                "/api/v2/products")
                .content(productJsonString)
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(requestBuilder).andReturn();

        MockHttpServletResponse response = result.getResponse();

        assertEquals(HttpStatus.CREATED.value(), response.getStatus());
        assertEquals("/api/v1/products/0", response.getHeader("product"));
    }

    @Test
    void saveProduct() throws Exception {

        this.mockMvc
                .perform(
                        post("/api/v2/products")
                                .content(this.objectMapper.writeValueAsBytes(
                                        Product.builder()
                                                .productId(1)
                                                .name("oreo").description("cookies").price(3.5).build()))
                                .contentType(MediaType.APPLICATION_JSON)
                )
                .andExpect(status().isCreated());

        verify(this.productService, times(1)).insert(any(Product.class));
        verifyNoMoreInteractions(this.productService);
    }
}