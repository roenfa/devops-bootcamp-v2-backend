package org.devops.bootcamp.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.devops.bootcamp.models.Product;
import org.devops.bootcamp.services.Service;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.autoconfigure.security.servlet.UserDetailsServiceAutoConfiguration;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.Arrays;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.doNothing;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import static org.mockito.Mockito.*;

@WebMvcTest(
        controllers = ProductController.class,
        excludeAutoConfiguration = {
                UserDetailsServiceAutoConfiguration.class, SecurityAutoConfiguration.class
        }
)
public class ProductControllerTests {
    final String productJsonString = "{\"id\":1,\"name\":\"Oreo\",\"description\":\"cookies\",\"price\":3.5}";

    @MockBean
    private Service<Product> productService;

    @Autowired
    ObjectMapper objectMapper;

    @Autowired
    private MockMvc mockMvc;

    @BeforeEach
    public void setUp() {
        given(this.productService.getAll())
                .willReturn(
                        Arrays.asList(
                                Product.builder().name("oreo").description("cookies").price(3.5).build(),
                                Product.builder().name("milk").description("drink").price(6.5).build()
                        ));

        given(this.productService.insert(any(Product.class)))
                .willReturn(Product.builder().name("oreo").description("cookies").price(3.5).build());

        doNothing().when(this.productService).delete(any(Long.class));
    }

    @Test
    public void createProduct() throws Exception {
        Product productMock = Product.builder()
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

        assertEquals("http://localhost:8080/api/v1/products", response.getHeader(HttpHeaders.LOCATION));
    }

    @Test
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
