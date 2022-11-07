package org.devops.bootcamp.controllers;

import org.json.JSONObject;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@RunWith(SpringRunner.class)
public class AuthenticationControllerTests {

    private MockMvc mockMvc;
    
    @Autowired
    public AuthenticationControllerTests(MockMvc mockMvc, AuthenticationController authenticationController) {
        this.mockMvc = mockMvc;
    }

    @Test
    public void existentUserCanGetTokenAndAuthentication() throws Exception {

        JSONObject requestBody = new JSONObject();
        requestBody.put("username", "sa");
        requestBody.put("password", "StrongPassword"); //need to be replaced by Real one

        String response = this.mockMvc.perform(MockMvcRequestBuilders
                        .post("/authenticate")
                        .content(requestBody.toString())
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn()
                .getResponse()
                .getContentAsString();

        this.mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/products")
                .header("Authorization", "Bearer " + new JSONObject(response).getString("token")))
                .andExpect(status().isOk());

    }

    @Test
    public void notExistentUserAuthentication() throws Exception {

        JSONObject requestBody = new JSONObject();
        requestBody.put("username", "root");
        requestBody.put("password", "12345");

        this.mockMvc.perform(MockMvcRequestBuilders
                        .post("/authenticate")
                        .content(requestBody.toString())
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isUnauthorized());

    }

}
