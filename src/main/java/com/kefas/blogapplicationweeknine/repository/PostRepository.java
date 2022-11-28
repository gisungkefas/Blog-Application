package com.kefas.blogapplicationweeknine.repository;

import com.kefas.blogapplicationweeknine.model.Post;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {

    Page<Post> findByCreatedBy(Long userId, Pageable pageable);
    Long countByCreatedBy(Long userId);
}
