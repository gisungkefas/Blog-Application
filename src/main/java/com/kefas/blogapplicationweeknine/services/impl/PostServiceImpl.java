package com.kefas.blogapplicationweeknine.services.impl;

import com.kefas.blogapplicationweeknine.dto.PostDto;
import com.kefas.blogapplicationweeknine.entities.Like;
import com.kefas.blogapplicationweeknine.entities.Post;
import com.kefas.blogapplicationweeknine.entities.User;
import com.kefas.blogapplicationweeknine.exceptions.PostNotFoundException;
import com.kefas.blogapplicationweeknine.exceptions.UserNotFoundException;
import com.kefas.blogapplicationweeknine.repositories.LikeRepository;
import com.kefas.blogapplicationweeknine.repositories.PostRepository;
import com.kefas.blogapplicationweeknine.repositories.UserRepository;
import com.kefas.blogapplicationweeknine.services.PostService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class PostServiceImpl implements PostService {

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private LikeRepository likeRepository;

    @Override
    public PostDto createPost(PostDto postDto, Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new UserNotFoundException("User with ID: "+ userId + " is not found"));

        Post post = new Post();
        post.setTitle(postDto.getTitle());
        post.setContent(postDto.getContent());
        post.setImageUrl(postDto.getImageUrl());
        post.setUser(user);
        postRepository.save(post);
        postDto.setUserId(userId);
        return postDto;
    }

    @Override
    public PostDto updatePost(PostDto postDto, Long postId) {
        Post post = postRepository.findById(postId).
                orElseThrow(()-> new PostNotFoundException("Post with ID: "+ postId +" is not found"));

        if(postDto.getTitle() != null && !postDto.getTitle().equals(post.getTitle())){
            post.setTitle(postDto.getTitle());
            post.setUpdatedDate(LocalDateTime.now());
        }

        if(postDto.getContent() != null && !postDto.getContent().equals(post.getContent())){
            post.setContent(postDto.getContent());
            post.setUpdatedDate(LocalDateTime.now());
        }

        if (postDto.getImageUrl() != null && !postDto.getImageUrl().equals(post.getImageUrl())){
            post.setImageUrl(postDto.getImageUrl());
            post.setUpdatedDate(LocalDateTime.now());
        }
        postRepository.save(post);
        return postDto;
    }

    @Override
    public String deletePost(Long postId) {
        Post post = postRepository.findById(postId).
                orElseThrow(()-> new PostNotFoundException("Post with ID: "+ postId +" is not found"));

        postRepository.delete(post);
        return "Post Deleted Successfully";
    }

    @Override
    public Post getPostById(Long postId) {

        return postRepository.findById(postId)
                .orElseThrow(() -> {
                    throw new PostNotFoundException("Post with ID: " + postId + " Not Found");
                });
    }

    @Override
    public List<Post> getAllPosts() {
        return postRepository.findAll();
    }

    @Override
    public String likePost(Long postId, Long userId) {
        Post post = postRepository.findById(postId)
                .orElseThrow(() -> {
                    throw new PostNotFoundException("Post with ID: " + postId + " Not Found");
                });

        User user = userRepository.findById(userId)
                .orElseThrow(() -> {
                    throw new PostNotFoundException("User with ID: " + userId + " Not Found");
                });

        Optional<Like> liked = likeRepository.findByPostAndUser(post, user);

        if (liked.isPresent()) {
            likeRepository.delete(liked.get());
            return "User Unliked the Post";
        }

        Like like = new Like();
        like.setPost(post);
        like.setUser(user);
        likeRepository.save(like);
        return "User liked the Post";
    }
}
