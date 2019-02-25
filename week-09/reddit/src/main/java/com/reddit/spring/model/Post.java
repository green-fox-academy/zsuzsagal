package com.reddit.spring.model;

import org.springframework.format.annotation.DateTimeFormat;
import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Post {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long postId;
  private String title;
  private int numberOfVotes;
  private String url;
  @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
  private LocalDateTime dateTime;
  @ManyToOne
  @JoinColumn(name = "user_id")
  User user;

  public Post() {
    dateTime = LocalDateTime.now();
  }

  public Post(String title, User user) {
    this();
    this.title = title;
    this.user = user;
  }

  public int upVote() {
    return numberOfVotes++;
  }

  public int downVote() {
    if (numberOfVotes > 0) {
      numberOfVotes--;
    }
    return numberOfVotes;
  }

  public Long getPostId() {
    return postId;
  }

  public void setPostId(Long id) {
    this.postId = id;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public int getNumberOfVotes() {
    return numberOfVotes;
  }

  public void setNumberOfVotes(int numberOfVotes) {
    this.numberOfVotes = numberOfVotes;
  }

  public String getUrl() {
    return url;
  }

  public void setUrl(String url) {
    this.url = url;
  }

  public LocalDateTime getDateTime() {
    return dateTime;
  }

  public void setDateTime(LocalDateTime dateTime) {
    this.dateTime = dateTime;
  }

  public User getUser() {
    return user;
  }

  public void setUser(User user) {
    this.user = user;
  }

}
