package org.devops.bootcamp.controllers;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.security.config.http.MatcherType.mvc;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc
public class AuthenticationControllerTests {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Test
    public void existentUserCanGetTokenAndAuthentication() throws Exception {
        String username = "bootcamp";
        String password = "password";

        String body = "{\"username\":\"" + username + "\", \"password\":\""+ password + "\"}";

        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.post("/authenticate")
                .content(body))
                .andExpect(status().isOk()).andReturn();

        String response = result.getResponse().getContentAsString();
        response = response.replace("{\"access_token\": \"", "");
        String token = response.replace("\"}", "");

        mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/products")
                .header("Authorization", "Bearer " + token))
                .andExpect(status().isOk());
    }
}
