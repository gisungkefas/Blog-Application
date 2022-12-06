package com.kefas.blogapplicationweeknine.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.kefas.blogapplicationweeknine.dto.UserDto;
import com.kefas.blogapplicationweeknine.services.UserService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(UserController.class)
class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper mapper;

    @Autowired
    private UserController userController;

    @MockBean
    private UserService userService;

    @AfterEach
    void tearDown() {
    }

    @Test
    void testCreateUser() throws Exception {
        UserDto userDto = new UserDto();
        userDto.setEmail("lisa@gmail.com");
        userDto.setFirstname("Lisa");
        userDto.setLastname("Lott");
        userDto.setPassword("1234");
        userDto.setPhoneNumber("4105551212");

        String requestBody = mapper.writeValueAsString(userDto);

        mockMvc.perform(MockMvcRequestBuilders.post("/api/v1/user/register", 42L)
                        .contentType("application/json").content(requestBody))
                .andExpect(status().isAccepted());
    }

    @Test
    void testUserLogin() throws Exception {
        UserDto userDto = new UserDto();
        userDto.setEmail("lisa@gmail.com");
        userDto.setPassword("1234");

        String requestBody = mapper.writeValueAsString(userDto);

        mockMvc.perform(MockMvcRequestBuilders.post("/api/v1/user/login", 42L)
                        .contentType("application/json").content(requestBody))
                .andExpect(status().isAccepted());
    }
}