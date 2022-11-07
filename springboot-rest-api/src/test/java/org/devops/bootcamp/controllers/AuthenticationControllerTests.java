package org.devops.bootcamp.controllers;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


import org.devops.bootcamp.models.DAOUser;


@SpringBootTest
@AutoConfigureMockMvc
public class AuthenticationControllerTests {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void mockApplicationUser() {
        DAOUser applicationUser = Mockito.mock(DAOUser.class);
        Authentication authentication = Mockito.mock(Authentication.class);
        SecurityContext securityContext = Mockito.mock(SecurityContext.class);
        Mockito.when(securityContext.getAuthentication()).thenReturn(authentication);
        SecurityContextHolder.setContext(securityContext);
        Mockito.when(SecurityContextHolder.getContext().getAuthentication().getPrincipal()).thenReturn(applicationUser);
    }

    @Test
    public void existentUserCanGetTokenAndAuthentication() throws Exception {

        String username = "user";
        String password = "password";

        String body = "{\"username\":\"" + username + "\", \"password\":\""+ password + "\"}";

        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.post("/authenticate")
                .accept("application/json")
                .contentType("application/json")
                .content(body))
                .andExpect(status().isOk()).andReturn();

        String response = result.getResponse().getContentAsString();
        response = response.replace("{\"token\":\"", "");
        String token = response.replace("\"}", "");


        mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/products")
                .header("Authorization", "Bearer " + token))
                .andExpect(status().isOk());
    }
}
