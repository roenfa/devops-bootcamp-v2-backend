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
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
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
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import static org.mockito.Mockito.*;

@SpringBootTest
@AutoConfigureMockMvc(addFilters = false)
/* @WebMvcTest(
        controllers = ProductControllerJpa.class,
        excludeAutoConfiguration = {
                UserDetailsServiceAutoConfiguration.class, SecurityAutoConfiguration.class,
                JwtUserDetailsService.class
        }
)
@EnableAutoConfiguration(exclude = SecurityAutoConfiguration.class) */
@DisplayName("ProductControllerTests - SpringTest")
public class ProductControllerJpaTests {
    final String productJsonString = "{\"id\":1,\"name\":\"Oreo\",\"description\":\"cookies\",\"price\":3.5}";

    @MockBean
    private ServiceJpa<Product> productServiceJpa;

    @MockBean
    private IProductRepository iProductRepository;

    @MockBean
    private IOrderRepository iOrderRepository;

    @MockBean
    private OrderControllerJpa orderControllerJpa;

    @MockBean
    private ProductControllerJpa productControllerJpa;

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
                        ));

        given(this.productServiceJpa.save(any(Product.class)))
                .willReturn(
                        new Product("oreo", "cookies", 3.5)
                        );

        doNothing().when(this.productServiceJpa).deleteById(any(Integer.class));
    }

    @Test
    public void listProductTestSuccess() throws Exception {
        Product productMock = new Product("oreo", "cookies", 3.5);

        Mockito.when(productServiceJpa.save(any(Product.class))).thenReturn(productMock);

        RequestBuilder requestBuilder = post(
                "/api/v2/products")
                .accept(MediaType.APPLICATION_JSON).content(productJsonString)
                .contentType(MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(requestBuilder).andReturn();

        MockHttpServletResponse response = result.getResponse();

        assertEquals(HttpStatus.OK.value(), response.getStatus());

        // assertEquals("/api/v2/products", response.getHeader(HttpHeaders.LOCATION));
    }

    @Test
    public void saveProductTestSuccess() throws Exception {

        Product productMock = new Product("oreo", "cookies", 3.5);
        this.mockMvc
                .perform(
                        post("/api/v2/products")
                                .content(this.objectMapper.writeValueAsBytes(
                                        productMock))
                                .contentType(MediaType.APPLICATION_JSON)
                                .characterEncoding("UTF-8")
                )
                .andExpect(status().isOk());

        verify(this.productServiceJpa, times(1)).save(any(Product.class));
        verifyNoMoreInteractions(this.productServiceJpa);
    }
}
