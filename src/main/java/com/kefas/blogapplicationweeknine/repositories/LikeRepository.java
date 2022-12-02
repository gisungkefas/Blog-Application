package com.kefas.blogapplicationweeknine.repositories;

import com.kefas.blogapplicationweeknine.entities.Like;
import com.kefas.blogapplicationweeknine.entities.Post;
import com.kefas.blogapplicationweeknine.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface LikeRepository extends JpaRepository<Like, Long>{
    Optional<Like> findByPostAndUser(Post post, User user);
}
