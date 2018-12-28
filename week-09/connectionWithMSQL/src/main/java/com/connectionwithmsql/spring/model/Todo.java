package com.connectionwithmsql.spring.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Todo {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;
  private String title;
  private Boolean urgent;
  private Boolean done;

  public Todo() {

  }

  public Todo(String title) {
    this.title = title;
    this.urgent = false;
    this.done = false;
  }

  public Long getId() {
    return id;
  }

  public String getTitle() {
    return title;
  }

  public Boolean getUrgent() {
    return urgent;
  }

  public Boolean getDone() {
    return done;
  }

}