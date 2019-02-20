package com.reddit.spring.service;

import com.reddit.spring.model.Post;
import com.reddit.spring.model.User;
import com.reddit.spring.repository.PostRepository;
import com.reddit.spring.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class RedditService {

  private PostRepository postRepository;
  private UserRepository userRepository;

  @Autowired
  public RedditService(PostRepository postRepository, UserRepository userRepository) {
    this.postRepository = postRepository;
    this.userRepository = userRepository;
  }

  public List<Post> getAllPosts() {
    return (List<Post>) postRepository.findAll();
  }

  public List<User> getAllUsers() {
    return (List<User>) userRepository.findAll();
  }

  public Post get(Long id) {
    Optional<Post> post = postRepository.findById(id);
    if (post.isPresent()) {
      return post.get();
    }
    throw new IndexOutOfBoundsException();
  }

  public void upVote(Long id) {
    Optional<Post> post = postRepository.findById(id);
    if (post.isPresent()) {
      post.get().upVote();
      postRepository.save(post.get());
    }
  }

  public void downVote(Long id) {
    Optional<Post> post = postRepository.findById(id);
    if (post.isPresent()) {
      post.get().downVote();
      postRepository.save(post.get());
    }
  }

  public void addPost(Post post) {
    postRepository.save(post);
  }

  public void deletePost(Long id) {
    postRepository.deleteById(id);
  }

  public List<Post> sortAllPostsByName(String username) {
    User user = findUserByName(username);
    return getAllPosts().stream()
            .filter(e -> e.getUser().getId().equals(user.getId()))
            .sorted(Comparator.comparing(Post::getNumberOfVotes).reversed()).collect(Collectors.toList());
  }

  public User findUserByName(String name) {
    return getAllUsers().stream()
            .filter(e -> e.getName().equals(name))
            .findFirst()
            .orElse(null);
  }
}
