package com.greenfoxacademy.springstart.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldRESTController {
  //  add @RestController annotation to this class.
  //  Add greeting method and use @RequestMapping annotation.
  //  Create and return a Greeting object when it is called.
  //  Recompile app (use the "Make Project (Ctrl-F9" at the top of your project if you've edited the existing project and are restarting)
  //  Open http://localhost:8080/world/greeting in your web browser
  //  Your output should look like: {"id":1,"content":"Hello, World!"}

  @RequestMapping("/world/greeting")
  public Greeting greeting(){
    return new Greeting("Hello, World!");
  }
}
