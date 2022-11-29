package com.kefas.blogapplicationweeknine.repositories;

import com.codewithdurgesh.blog.entities.Post;
import com.codewithdurgesh.blog.services.entities.Category;
import com.codewithdurgesh.blog.services.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PostRepo extends JpaRepository<com.codewithdurgesh.blog.services.entities.Post, Integer> {

	List<com.codewithdurgesh.blog.services.entities.Post> findByUser(User user);
	List<com.codewithdurgesh.blog.services.entities.Post> findByCategory(Category category);
	
	@Query("select p from Post p where p.title like :key")
	List<com.codewithdurgesh.blog.services.entities.Post> searchByTitle(@Param("key") String title);
	

}
