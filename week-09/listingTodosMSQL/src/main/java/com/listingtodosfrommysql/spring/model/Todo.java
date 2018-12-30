package com.listingtodosfrommysql.spring.model;

import javax.persistence.*;

@Entity
public class Todo {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;
  private String title;
  private Boolean urgent;
  private Boolean done;
  @ManyToOne
  private Assignee assignee;

  public Todo() {
  }

  public Todo(String title, Boolean urgent, Boolean done, Assignee assignee) {
    this.title = title;
    this.urgent = urgent;
    this.done = done;
    this.assignee = assignee;
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

  public void setId(Long id) {
    this.id = id;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public void setUrgent(Boolean urgent) {
    this.urgent = urgent;
  }

  public void setDone(Boolean done) {
    this.done = done;
  }

  public Assignee getAssignee() {
    return assignee;
  }

  public void setAssignee(Assignee assignee) {
    this.assignee = assignee;
  }
}