package org.devops.bootcamp.controllers;

import org.devops.bootcamp.security.models.JwtRequest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
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

    @Test
    public void existentUserCanGetTokenAndAuthentication() throws Exception {
        String username = "jsdafuanito";
        String password = "password";

        JwtRequest jwtRequest = new JwtRequest(username, password);

        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.post("/authenticate")
                .content(jwtRequest.toString()))
                .andExpect(status().isOk())
                .andReturn();

        String token = result.getResponse().getContentAsString();

        mockMvc.perform(MockMvcRequestBuilders.get("/hello")
                        .header("Authorization", "Bearer " + token))
                .andExpect(status().isOk());
    }
}
