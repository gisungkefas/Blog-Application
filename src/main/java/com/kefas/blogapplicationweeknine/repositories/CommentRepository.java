package com.kefas.blogapplicationweeknine.repositories;

import com.kefas.blogapplicationweeknine.entities.Comment;
import com.kefas.blogapplicationweeknine.entities.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long> {
    List<Comment> findAllCommentByPost(Post post);
}
