package com.greenfoxacademy.springstart.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class WebGreetCounter {
//  Lets do a web app which can count the website load and greet the user as the previous counter task.
//  Open http://localhost:8080/web/greeting?name=Your%20name in your web browser
//  Your output should look like: Hello, Your name! This site was loaded 3 times since last server start.

  @RequestMapping("/web/greetcounter")
  public String greeting(Model model, @RequestParam String name) {
    Greeting greeting = new Greeting(name);
    model.addAttribute("name", name);
    model.addAttribute("atomic", greeting.getId());
    return "greeting";
  }
}


