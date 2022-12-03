package com.kefas.blogapplicationweeknine.services.impl;

import com.kefas.blogapplicationweeknine.dto.CommentDto;
import com.kefas.blogapplicationweeknine.entities.Comment;
import com.kefas.blogapplicationweeknine.entities.Post;
import com.kefas.blogapplicationweeknine.entities.User;
import com.kefas.blogapplicationweeknine.exceptions.CommentNotFoundException;
import com.kefas.blogapplicationweeknine.exceptions.PostNotFoundException;
import com.kefas.blogapplicationweeknine.exceptions.UserNotFoundException;
import com.kefas.blogapplicationweeknine.repositories.CommentRepository;
import com.kefas.blogapplicationweeknine.repositories.PostRepository;
import com.kefas.blogapplicationweeknine.repositories.UserRepository;
import com.kefas.blogapplicationweeknine.services.CommentService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@AllArgsConstructor
public class CommentServiceImpl implements CommentService {

	private final PostRepository postRepository;

	private final CommentRepository commentRepository;

	private final UserRepository userRepository;

	@Override
	public CommentDto createComment(CommentDto commentDto, Long postId) {

		String content = commentDto.getContent();

		Long userId = commentDto.getUserId();

		Post post = postRepository.findById(postId)
				.orElseThrow(() -> {
					throw new PostNotFoundException ("Post with ID: " + postId + " Not Found");
				});
		User user = userRepository.findById(userId)
				.orElseThrow(() -> new UserNotFoundException("User with ID: " + userId + " Not Found"));
		Comment comment = new Comment();
		comment.setContent(content);
		comment.setPost(post);
		comment.setUser(user);
		commentRepository.save(comment);

		return commentDto;
	}

	@Override
	public List<Comment> getAllPostComment(Long postId) {
		Post post = postRepository.findById(postId)
				.orElseThrow(() -> new PostNotFoundException("Post with ID: " + postId + " is not Found"));

		return commentRepository.findAllCommentByPost(post);
	}

	@Override
	public String deleteComment(Long commentId) {
		Comment comment = commentRepository.findById(commentId).
				orElseThrow(()-> new CommentNotFoundException("Comment with ID: "+ commentId + "is not found"));
		commentRepository.delete(comment);

		return "Comment Deleted Successfully";
	}
}
