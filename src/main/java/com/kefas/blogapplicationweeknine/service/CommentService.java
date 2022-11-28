package com.kefas.blogapplicationweeknine.service;

import com.kefas.blogapplicationweeknine.model.Comment;
import com.kefas.blogapplicationweeknine.payload.CommentPayload;
import com.kefas.blogapplicationweeknine.response.PagedResponse;

import java.nio.file.attribute.UserPrincipal;

public interface CommentService {

    PagedResponse<Comment> getAllComments(Long postId, int page, int size);
    Comment addComment(CommentPayload commentPayload, Long postId, UserPrincipal currentUser);
    Comment getComment(Long postId, Long id);
    Comment updateComment(Long postId, Long id, CommentPayload commentPayload, UserPrincipal currentUser);
}
