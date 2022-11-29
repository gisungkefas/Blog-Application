package com.kefas.blogapplicationweeknine.services;

import com.kefas.blogapplicationweeknine.dto.PostDto;
import com.kefas.blogapplicationweeknine.response.PostResponse;

import java.util.List;

public interface PostService {

	PostDto createPost(PostDto postDto, Integer userId, Integer categoryId);

	PostDto updatePost(PostDto postDto, Integer postId);

	void deletePost(Integer postId);
	
	PostResponse getAllPost(Integer pageNumber, Integer pageSize, String sortBy, String sortDir);

	PostDto getPostById(Integer postId);
	
	List<PostDto> getPostsByCategory(Integer categoryId);

	List<PostDto> getPostsByUser(Integer userId);

	List<PostDto> searchPosts(String keyword);

}
