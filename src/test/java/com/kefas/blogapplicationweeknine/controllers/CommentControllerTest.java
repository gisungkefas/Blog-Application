package com.kefas.blogapplicationweeknine.controllers;

import static org.mockito.Mockito.any;
import static org.mockito.Mockito.when;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.kefas.blogapplicationweeknine.dto.CommentDto;
import com.kefas.blogapplicationweeknine.services.CommentService;

import java.util.ArrayList;

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

@ContextConfiguration(classes = {CommentController.class})
@ExtendWith(SpringExtension.class)
class CommentControllerTest {
    @Autowired
    private CommentController commentController;

    @MockBean
    private CommentService commentService;

    @Test
    void testCreateComment() throws Exception {
        CommentDto commentDto = new CommentDto();
        commentDto.setContent("Not all who wander are lost");
        commentDto.setUserId(123L);
        when(commentService.createComment((CommentDto) any(), (Long) any())).thenReturn(commentDto);

        CommentDto commentDto1 = new CommentDto();
        commentDto1.setContent("Not all who wander are lost");
        commentDto1.setUserId(123L);
        String content = (new ObjectMapper()).writeValueAsString(commentDto1);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/api/v1/post/{postId}/comment", 123L)
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(commentController)
                .build()
                .perform(requestBuilder);
        actualPerformResult.andExpect(MockMvcResultMatchers.status().isCreated())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(
                        MockMvcResultMatchers.content().string("{\"content\":\"Not all who wander are lost\",\"userId\":123}"));
    }

    @Test
    void testGetAllPostComment() throws Exception {
        when(commentService.getAllPostComment((Long) any())).thenReturn(new ArrayList<>());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/v1/post/{postId}/comments", 123L);
        MockMvcBuilders.standaloneSetup(commentController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("[]"));
    }
}

