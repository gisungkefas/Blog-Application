package com.kefas.blogapplicationweeknine.services;

import com.kefas.blogapplicationweeknine.dto.PostDto;
import com.kefas.blogapplicationweeknine.entities.Post;
import com.kefas.blogapplicationweeknine.response.PagedResponse;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public interface PostService {

	PostDto createPost(PostDto postDto, Long userId);

	PostDto updatePost(PostDto postDto, Long postId);

	String deletePost(PostDto postDto, Long postId);

	Post getPostById(Long postId);

	List<Post> getAllPosts();

//	List<PostDto> searchPsts(String keyword);

	String likePost(Long postId, Long userId);

}
