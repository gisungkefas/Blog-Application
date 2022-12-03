package com.kefas.blogapplicationweeknine.controllers;

import static org.mockito.Mockito.any;
import static org.mockito.Mockito.when;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.kefas.blogapplicationweeknine.dto.PostDto;
import com.kefas.blogapplicationweeknine.entities.Post;
import com.kefas.blogapplicationweeknine.entities.User;
import com.kefas.blogapplicationweeknine.services.PostService;

import java.time.LocalDateTime;

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

@ContextConfiguration(classes = {PostController.class})
@ExtendWith(SpringExtension.class)
class PostControllerTest {
    @Autowired
    private PostController postController;

    @MockBean
    private PostService postService;

    @Test
    void testCreatePost() throws Exception {
        PostDto postDto = new PostDto();
        postDto.setContent("Not all who wander are lost");
        postDto.setImageUrl("https://example.org/example");
        postDto.setTitle("Dr");
        postDto.setUserId(123L);
        when(postService.createPost((PostDto) any(), (Long) any())).thenReturn(postDto);

        PostDto postDto1 = new PostDto();
        postDto1.setContent("Not all who wander are lost");
        postDto1.setImageUrl("https://example.org/example");
        postDto1.setTitle("Dr");
        postDto1.setUserId(123L);
        String content = (new ObjectMapper()).writeValueAsString(postDto1);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/api/v1/user/{userId}/createPost", 123L)
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(postController).build().perform(requestBuilder);
        actualPerformResult.andExpect(MockMvcResultMatchers.status().isCreated())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(
                                "{\"title\":\"Dr\",\"content\":\"Not all who wander are lost\",\"imageUrl\":\"https://example.org/example\","
                                        + "\"userId\":123}"));
    }

    @Test
    void testGetAllPosts() throws Exception {
        when(postService.getAllPosts()).thenReturn(new ArrayList<>());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/v1/posts");
        MockMvcBuilders.standaloneSetup(postController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("[]"));
    }

    @Test
    void testGetAllPosts2() throws Exception {
        when(postService.getAllPosts()).thenReturn(new ArrayList<>());
        MockHttpServletRequestBuilder getResult = MockMvcRequestBuilders.get("/api/v1/posts");
        getResult.characterEncoding("Encoding");
        MockMvcBuilders.standaloneSetup(postController)
                .build()
                .perform(getResult)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("[]"));
    }

    @Test
    void testGetPostById() throws Exception {
        User user = new User();
        user.setEmail("jane.doe@example.org");
        user.setFirstname("Jane");
        user.setLastname("Doe");
        user.setPassword("iloveyou");
        user.setPhoneNumber("4105551212");
        user.setUserId(123L);

        Post post = new Post();
        post.setComments(new ArrayList<>());
        post.setContent("Not all who wander are lost");
        post.setCreatedDate(LocalDateTime.of(1, 1, 1, 1, 1));
        post.setImageUrl("https://example.org/example");
        post.setPostId(123L);
        post.setTitle("Dr");
        post.setUpdatedDate(LocalDateTime.of(1, 1, 1, 1, 1));
        post.setUser(user);
        when(postService.getPostById((Long) any())).thenReturn(post);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/v1/posts/{postId}", 123L);
        MockMvcBuilders.standaloneSetup(postController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(
                                "{\"postId\":123,\"title\":\"Dr\",\"content\":\"Not all who wander are lost\",\"imageUrl\":\"https://example.org"
                                        + "/example\",\"createdDate\":[1,1,1,1,1],\"updatedDate\":[1,1,1,1,1],\"user\":{\"userId\":123,\"firstname\":\"Jane"
                                        + "\",\"lastname\":\"Doe\",\"email\":\"jane.doe@example.org\",\"phoneNumber\":\"4105551212\",\"password\":\"iloveyou\"},"
                                        + "\"comments\":[]}"));
    }

    @Test
    void testDeletePost() throws Exception {
        when(postService.deletePost((Long) any())).thenReturn("Delete Post");
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.delete("/api/v1/posts/{postId}/delete",
                123L);
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(postController)
                .build()
                .perform(requestBuilder);
        actualPerformResult.andExpect(MockMvcResultMatchers.status().isAccepted())
                .andExpect(MockMvcResultMatchers.content().contentType("text/plain;charset=ISO-8859-1"))
                .andExpect(MockMvcResultMatchers.content().string("Delete Post"));
    }

    @Test
    void testDeletePost2() throws Exception {
        when(postService.deletePost((Long) any())).thenReturn("Delete Post");
        MockHttpServletRequestBuilder deleteResult = MockMvcRequestBuilders.delete("/api/v1/posts/{postId}/delete", 123L);
        deleteResult.characterEncoding("Encoding");
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(postController).build().perform(deleteResult);
        actualPerformResult.andExpect(MockMvcResultMatchers.status().isAccepted())
                .andExpect(MockMvcResultMatchers.content().contentType("text/plain;charset=ISO-8859-1"))
                .andExpect(MockMvcResultMatchers.content().string("Delete Post"));
    }

    @Test
    void testUpdatePost() throws Exception {
        PostDto postDto = new PostDto();
        postDto.setContent("Not all who wander are lost");
        postDto.setImageUrl("https://example.org/example");
        postDto.setTitle("Dr");
        postDto.setUserId(123L);
        when(postService.updatePost((PostDto) any(), (Long) any())).thenReturn(postDto);

        PostDto postDto1 = new PostDto();
        postDto1.setContent("Not all who wander are lost");
        postDto1.setImageUrl("https://example.org/example");
        postDto1.setTitle("Dr");
        postDto1.setUserId(123L);
        String content = (new ObjectMapper()).writeValueAsString(postDto1);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.put("/api/v1/posts/{postId}/update", 123L)
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);
        MockMvcBuilders.standaloneSetup(postController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(
                                "{\"title\":\"Dr\",\"content\":\"Not all who wander are lost\",\"imageUrl\":\"https://example.org/example\","
                                        + "\"userId\":123}"));
    }

    @Test
    void testLikePost() throws Exception {
        when(postService.likePost((Long) any(), (Long) any())).thenReturn("Like Post");
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/v1/{postId}/like/{userId}", 123L,
                123L);
        MockMvcBuilders.standaloneSetup(postController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("text/plain;charset=ISO-8859-1"))
                .andExpect(MockMvcResultMatchers.content().string("Like Post"));
    }

    @Test
    void testLikePost2() throws Exception {
        when(postService.likePost((Long) any(), (Long) any())).thenReturn("Like Post");
        MockHttpServletRequestBuilder getResult = MockMvcRequestBuilders.get("/api/v1/{postId}/like/{userId}", 123L,
                123L);
        getResult.characterEncoding("Encoding");
        MockMvcBuilders.standaloneSetup(postController)
                .build()
                .perform(getResult)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("text/plain;charset=ISO-8859-1"))
                .andExpect(MockMvcResultMatchers.content().string("Like Post"));
    }
}

