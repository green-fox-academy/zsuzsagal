package com.greenfoxacademy.springstart.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class HelloUserRESTController {
//  Please improve your previous app to greet you and get the name from url query parameter.
//  You should use @RequestParam annotation
//  Recompile app
//  Open http://localhost:8080/greeting?name=Zsuzsa in your web browser
//  Your output should look like: {"id":1,"content":"Hello, Your name!"}

  @RequestMapping("/user/greeting")
  public Greeting greeting(@RequestParam(name="name") String name){
    return new Greeting("Hello, " + name + "!" );
  }
}
