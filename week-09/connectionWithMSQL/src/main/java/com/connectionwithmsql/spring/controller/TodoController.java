package com.connectionwithmsql.spring.controller;

import com.connectionwithmsql.spring.repository.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/todo")
public class TodoController {

  private Repository repository;

  @Autowired
  public TodoController(Repository repository) {
    this.repository = repository;
  }

  @GetMapping({"/","/list"})
  public String list(Model model) {
    model.addAttribute("todos",repository.findAll());
    return "todolist";
  }
}