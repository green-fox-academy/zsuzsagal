package com.reddit.spring.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class User {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long userId;
  private String name;
  //private String password;

  @OneToMany(cascade = CascadeType.PERSIST, mappedBy = "user")
  private List<Post> posts;

  public User(){
  }

  public User(String name){
    this.name = name;
    //this.posts = new ArrayList<>(); // do we need this here ?
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Long getId() {
    return userId;
  }

  public void setId(Long id) {
    this.userId = id;
  }

  public Long getUserId() {
    return userId;
  }

  public void setUserId(Long userId) {
    this.userId = userId;
  }

  public List<Post> getPosts() {
    return posts;
  }

  public void setPosts(List<Post> posts) {
    this.posts = posts;
  }
}
