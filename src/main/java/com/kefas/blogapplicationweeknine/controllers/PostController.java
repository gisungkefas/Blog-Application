package com.kefas.blogapplicationweeknine.controllers;

import com.kefas.blogapplicationweeknine.dto.PostDto;
import com.kefas.blogapplicationweeknine.entities.Post;
import com.kefas.blogapplicationweeknine.response.PagedResponse;
import com.kefas.blogapplicationweeknine.services.PostService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/v1/")
public class PostController {

	private PostService postService;

	@PostMapping("/user/{userId}/createPost")
	public ResponseEntity<PostDto> createPost(@Valid @RequestBody PostDto postDto, @PathVariable Long userId) {
		PostDto createPost = this.postService.createPost(postDto, userId);
		return new ResponseEntity<>(createPost, HttpStatus.CREATED);
	}

	@GetMapping("/posts")
	public ResponseEntity<List<Post>> getAllPosts(){
		List<Post> posts = postService.getAllPosts();
		return new ResponseEntity<>(posts, HttpStatus.OK);
	}

	@GetMapping("/posts/{postId}")
	public ResponseEntity<Post> getPostById(@PathVariable Long postId){
		Post post = postService.getPostById(postId);
		return new ResponseEntity<>(post, HttpStatus.OK);

	}

	@DeleteMapping("/posts/{postId}")
	public ResponseEntity<String> deletePost(@RequestBody PostDto postDto, @PathVariable Long postId){
		return new ResponseEntity<>(postService.deletePost(postDto, postId), HttpStatus.ACCEPTED);
	}

	@PutMapping("/posts/{postId}")
	public ResponseEntity<PostDto> updatePost(@RequestBody PostDto postDto, @PathVariable Long postId) {
		PostDto updatePost = this.postService.updatePost(postDto, postId);
		return new ResponseEntity<>(updatePost, HttpStatus.OK);

	}

//	@GetMapping("/posts/search/{keywords}")
//	public ResponseEntity<List<PostDto>> searchPostByTitle(@PathVariable("keywords") String keywords) {
//		List<PostDto> result = this.postService.searchPosts(keywords);
//		return new ResponseEntity<>(result, HttpStatus.OK);
//	}
}
