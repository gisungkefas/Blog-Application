package com.kefas.blogapplicationweeknine.services;

import com.kefas.blogapplicationweeknine.dto.CommentDto;

public interface CommentService {

	CommentDto createComment(CommentDto commentDto, Integer postId);

    void deleteComment(Integer commentId);

}
