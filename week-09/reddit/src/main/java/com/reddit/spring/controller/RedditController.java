package com.reddit.spring.controller;

import com.reddit.spring.model.Post;
import com.reddit.spring.model.User;
import com.reddit.spring.service.RedditService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class RedditController {

  private RedditService redditService;

  @Autowired
  public RedditController(RedditService redditService) {
    this.redditService = redditService;
  }

  @GetMapping("/")
  public String showWebsite() {
    return "posts";
  }

  @GetMapping("/posts")
  public String showAllPosts(Model model, @RequestParam(name = "username") String name) {
    model.addAttribute("posts", redditService.sortAllPostsByName(name));
    model.addAttribute("username", name);
    return "posts";
  }

  @GetMapping("posts/{id}")
  public String singlePost(Model model, @PathVariable Long id) {
    model.addAttribute("post", redditService.get(id));
    return "single-post";
  }

  @GetMapping("/{id}/upvote")
  public String upVote(@PathVariable Long id, @RequestParam(name = "username") String name) {
    redditService.upVote(id);
    return "redirect:/posts?username=" + name;
  }

  @GetMapping("/{id}/downvote")
  public String downVote(@PathVariable Long id, @RequestParam(name = "username") String name) {
    redditService.downVote(id);
    return "redirect:/posts?username=" + name;
  }

  @GetMapping("/add")
  public String addNewPost(Model model, @RequestParam(name = "username") String userName) {
    model.addAttribute("post", new Post());
    model.addAttribute("userName", userName);
    return "add";
  }

  @PostMapping("/add/{userName}")
  public String showUpdatedPostList(@ModelAttribute Post post, @PathVariable String userName) {
    User user = redditService.findUserByName(userName);
    post.setUser(user);
    redditService.addPost(post);
    return "redirect:/posts?username=" + userName;
  }

  @GetMapping("/{id}/delete")
  public String deletePost(@PathVariable Long id, @RequestParam(name = "username") String name) {
    redditService.deletePost(id);
    return "redirect:/posts?username=" + name;
  }

  @GetMapping("/login")
  public String showLogin() {
    return "login";
  }

  @PostMapping("/login")
  public String listPostsByUser(@RequestParam(name = "name") String name) {
    User found = redditService.findUserByName(name);
    if (found == null) {
      return "redirect:/login";
    } else {
      return "redirect:/posts?username=" + name;
    }
  }
}
