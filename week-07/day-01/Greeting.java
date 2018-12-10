package com.greenfoxacademy.springstart.controllers;

import java.util.concurrent.atomic.AtomicLong;

public class Greeting {
//  Create "Greeting" class with "long id" and "String content" fields.
//  Create getters for the fields
//  Create a constructor using all fields
//  Add "HelloRESTController" class to controllers package and add @RestController annotation to this class.
//  Add greeting method and use @RequestMapping annotation.
//  Create and return a Greeting object when it is called.
//  Recompile app (use the "Make Project (Ctrl-F9" at the top of your project if you've edited the existing project and are restarting)
//  Open http://localhost:8080/greeting in your web browser
//  Your output should look like: {"id":1,"content":"Hello, World!"}


//  Lets improve your previous app to able to count the greet number. (count api calls)
//  You should use AtomicLong class.
//  Recompile app
//  Open http://localhost:8080/greeting?name=Your%20name in your web browser
//  Your output should looks like: {"id":1,"content":"Hello, Your name!"}
//  Then at next call your output should look like: {"id":2,"content":"Hello, Your name!"} and so on...


  long id;
  String content;
  public static final AtomicLong ATOMIC_LONG = new AtomicLong(1);


  public Greeting() {
  }


  public Greeting(String content) {
    this.id = ATOMIC_LONG.getAndIncrement();
    this.content = content;
  }

  public long getId() {
    return id;
  }

  public String getContent() {
    return content;
  }
}
