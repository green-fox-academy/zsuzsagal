package com.greenfoxacademy.springstart.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloWebController {

  @RequestMapping("/web/helloweb")
  public String greeting(Model model) {
    model.addAttribute("name", "Zsuzsa");
    return "helloweb";
  }
}



