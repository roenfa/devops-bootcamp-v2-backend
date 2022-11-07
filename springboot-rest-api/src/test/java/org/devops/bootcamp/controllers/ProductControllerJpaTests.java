package org.devops.bootcamp.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;

import org.devops.bootcamp.config.JwtRequestFilter;
import org.devops.bootcamp.models.Product;
import org.devops.bootcamp.repositories.IOrderRepository;
import org.devops.bootcamp.repositories.IProductRepository;
import org.devops.bootcamp.repositories.IUserRepository;
import org.devops.bootcamp.security.services.JwtUserDetailsService;
// import org.devops.bootcamp.services.Service;
import org.devops.bootcamp.services_jpa.ServiceJpa;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.autoconfigure.security.servlet.UserDetailsServiceAutoConfiguration;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.doNothing;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

import static org.mockito.Mockito.*;

@WebMvcTest(
        controllers = ProductControllerJpa.class,
        excludeAutoConfiguration = {
                UserDetailsServiceAutoConfiguration.class, SecurityAutoConfiguration.class,
                JwtUserDetailsService.class
        }
)
@EnableAutoConfiguration(exclude = SecurityAutoConfiguration.class)
@DisplayName("ProductControllerTests - SpringTest")
public class ProductControllerJpaTests {
    final String productJsonString = "{\"id\":1,\"name\":\"Oreo\",\"description\":\"cookies\",\"price\":3.5}";

//     @MockBean
//     private Service<Product> productService;

    @MockBean
    private ServiceJpa<Product> productServiceJpa;

    @MockBean
    private IProductRepository iProductRepository;

    @MockBean
    private IOrderRepository iOrderRepository;

    @MockBean
    private IUserRepository iUserRepository;

    @MockBean
    private JwtRequestFilter jwtRequestFilter;

    @Autowired
    ObjectMapper objectMapper;

    @Autowired
    private MockMvc mockMvc;

    @BeforeEach
    public void setUp() {
        given(this.productServiceJpa.findAll())
                .willReturn(
                        Arrays.asList(
                                new Product("oreo", "cookies", 3.5),
                                new Product("milk", "drink", 6.5)
                                // Product.builder().productId(1).name("oreo").description("cookies").price(3.5).build(),
                                // Product.builder().productId(2).name("milk").description("drink").price(6.5).build()
                        ));

        given(this.productServiceJpa.save(any(Product.class)))
                .willReturn(
                        new Product("oreo", "cookies", 3.5)
                        // Product.builder().productId(1).name("oreo").description("cookies").price(3.5).build()
                        );

        doNothing().when(this.productServiceJpa).deleteById(any(Integer.class));
        // doNothing().when(this.productService).delete(any(Integer.class));
    }

    @Test
    public void saveProductTestSuccess() throws Exception {
        /* Product productMock = Product.builder()
                .productId(1)
                .name("Oreo")
                .description("cookies")
                .price(3.5).build(); */
        Product productMock = new Product("oreo", "cookies", 3.5);

        // productService.insert to respond back with productMock
        Mockito.when(productServiceJpa.save(any(Product.class))).thenReturn(productMock);
        // Mockito.when(productService.insert(any(Product.class))).thenReturn(productMock);

        RequestBuilder requestBuilder = post(
                "/api/v2/products")
                .accept(MediaType.APPLICATION_JSON).content(productJsonString)
                .contentType(MediaType.APPLICATION_JSON);
        /* RequestBuilder requestBuilder = post(
                "/api/v1/products")
                .accept(MediaType.APPLICATION_JSON).content(productJsonString)
                .contentType(MediaType.APPLICATION_JSON); */

        MvcResult result = mockMvc.perform(requestBuilder).andReturn();

        MockHttpServletResponse response = result.getResponse();

        assertEquals(HttpStatus.CREATED.value(), response.getStatus());

        assertEquals("http://localhost:8080/api/v2/products", response.getHeader(HttpHeaders.LOCATION));
        // assertEquals("http://localhost:8080/api/v1/products", response.getHeader(HttpHeaders.LOCATION));
    }

    @Test
    public void testSave() throws Exception {

        /* this.mockMvc
                .perform(
                        post("/api/v1/products")
                                .content(this.objectMapper.writeValueAsBytes(
                                        Product.builder()
                                                .productId(1)
                                                .name("oreo").description("cookies").price(3.5).build()))
                                .contentType(MediaType.APPLICATION_JSON)
                )
                .andExpect(status().isCreated());

        verify(this.productService, times(1)).insert(any(Product.class));
        verifyNoMoreInteractions(this.productService); */
    }
}
