package com.kefas.blogapplicationweeknine.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.kefas.blogapplicationweeknine.dto.UserDto;
import com.kefas.blogapplicationweeknine.services.UserService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.when;

@ContextConfiguration(classes = {UserController.class})
@ExtendWith(SpringExtension.class)
class UserControllerTest {

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
        userDto.setEmail("jane.doe@example.org");
        userDto.setFirstname("Jane");
        userDto.setLastname("Doe");
        userDto.setPassword("iloveyou");
        userDto.setPhoneNumber("4105551212");
        when(userService.createUser((UserDto) any())).thenReturn(userDto);

        UserDto userDto1 = new UserDto();
        userDto1.setEmail("jane.doe@example.org");
        userDto1.setFirstname("Jane");
        userDto1.setLastname("Doe");
        userDto1.setPassword("iloveyou");
        userDto1.setPhoneNumber("4105551212");
        String content = (new ObjectMapper()).writeValueAsString(userDto1);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/api/v1/user/register")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(userController)
                .build()
                .perform(requestBuilder);
        actualPerformResult.andExpect(MockMvcResultMatchers.status().isAccepted())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(
                                "{\"firstname\":\"Jane\",\"lastname\":\"Doe\",\"email\":\"jane.doe@example.org\",\"phoneNumber\":\"4105551212\",\"password"
                                        + "\":\"iloveyou\"}"));
    }

    @Test
    void testUserLogin() throws Exception {
        when(userService.userLogin((UserDto) any())).thenReturn("User Login");

        UserDto userDto = new UserDto();
        userDto.setEmail("jane.doe@example.org");
        userDto.setFirstname("Jane");
        userDto.setLastname("Doe");
        userDto.setPassword("iloveyou");
        userDto.setPhoneNumber("4105551212");
        String content = (new ObjectMapper()).writeValueAsString(userDto);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/api/v1/user/login")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(userController)
                .build()
                .perform(requestBuilder);
        actualPerformResult.andExpect(MockMvcResultMatchers.status().isAccepted())
                .andExpect(MockMvcResultMatchers.content().contentType("text/plain;charset=ISO-8859-1"))
                .andExpect(MockMvcResultMatchers.content().string("User Login"));
    }
}