package com.kefas.blogapplicationweeknine.controllers;

import com.kefas.blogapplicationweeknine.dto.CommentDto;
import com.kefas.blogapplicationweeknine.entities.Comment;
import com.kefas.blogapplicationweeknine.services.CommentService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1")
public class CommentController {

	private final CommentService commentService;

	@PostMapping("/post/{postId}/comment")
	public ResponseEntity<CommentDto> createComment(@Valid @RequestBody CommentDto comment, @PathVariable Long postId) {
		CommentDto createComment = this.commentService.createComment(comment, postId);
		return new ResponseEntity<CommentDto>(createComment, HttpStatus.CREATED);
	}

	@GetMapping("/post/comments")
	public ResponseEntity<List<Comment>> getAllPostComment(@PathVariable Long postId){
		List<Comment> comments = commentService.getAllPostComment(postId);
		return new ResponseEntity<>(comments, HttpStatus.OK);
	}

	@DeleteMapping("/comments/{commentId}/delete")
	public ResponseEntity<String> deleteComment(@RequestBody CommentDto commentDto,@PathVariable Long commentId){
		return new ResponseEntity<>(commentService.deleteComment(commentId, commentDto), HttpStatus.ACCEPTED);
	}

}
