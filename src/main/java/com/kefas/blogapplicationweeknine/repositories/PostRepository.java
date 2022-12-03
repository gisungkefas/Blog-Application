package com.kefas.blogapplicationweeknine.repositories;

import com.kefas.blogapplicationweeknine.entities.Post;
import com.kefas.blogapplicationweeknine.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, Long> {

	List<Post> findByUser(User user);
}
