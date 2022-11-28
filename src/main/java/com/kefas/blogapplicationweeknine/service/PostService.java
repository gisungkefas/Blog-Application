package com.kefas.blogapplicationweeknine.service;

import com.kefas.blogapplicationweeknine.model.Post;
import com.kefas.blogapplicationweeknine.payload.PostPayload;
import com.kefas.blogapplicationweeknine.response.PagedResponse;
import com.kefas.blogapplicationweeknine.response.PostResponse;

import java.nio.file.attribute.UserPrincipal;

public interface PostService {

    PagedResponse<Post> getAllPots(int page, int size);
    PagedResponse<Post> getPostsByCreatedBy(String email, int page, int size);
    Post updatePost(Long id, PostPayload newPostRequest, UserPrincipal currentUser);
    PostResponse addPost(PostPayload postRequest, UserPrincipal currentUser);
    Post getPost(Long id);
}
