package com.reddit.spring.controller;

import com.reddit.spring.model.Post;
import com.reddit.spring.model.User;
import com.reddit.spring.service.RedditService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class RedditRestController {

  private RedditService redditService;

  @Autowired
  public RedditRestController(RedditService redditService) {
    this.redditService = redditService;
  }

  @PostMapping("/api/add/{userName}")
  public ResponseEntity showUpdatedPostList(@RequestBody Post post, @PathVariable String userName) {
    User user = redditService.findUserByName(userName);
    if (user == null) {
      return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    } else {
      post.setUser(user);
      redditService.addPost(post);
      return ResponseEntity.ok(post);
    }
  }

  //from Postman only:
  @DeleteMapping("/{id}/delete")
  public ResponseEntity deletePost(@PathVariable Long id) {
    try {
      redditService.deletePost(id);
    } catch (Exception e) {
      return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }
    return ResponseEntity.status(200).build();
  }

}
