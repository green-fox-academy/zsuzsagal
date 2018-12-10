package com.greenfoxacademy.springstart.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@Controller
public class RegisterController {

  @GetMapping("/signup")
  public String home(){
    return "form";
  }

  @PostMapping("/signup")
  public String register(@RequestBody  String name, @RequestBody String email){
    System.out.println(name);
    System.out.println(email);
    return "newsletter";
  }
}


