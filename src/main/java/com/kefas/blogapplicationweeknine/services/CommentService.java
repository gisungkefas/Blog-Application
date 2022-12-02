package com.kefas.blogapplicationweeknine.services;

import com.kefas.blogapplicationweeknine.dto.CommentDto;
import com.kefas.blogapplicationweeknine.entities.Comment;

import java.util.List;

public interface CommentService {

	CommentDto createComment(CommentDto commentDto, Long postId);

	List<Comment> getAllPostComment(Long postId);

	String deleteComment(Long commentId, CommentDto commentDto);
}
