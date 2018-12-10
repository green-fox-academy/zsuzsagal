package com.greenfoxacademy.springstart.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class SayHelloToAllTheWorld {

  String[] hellos = {"Mirëdita", "Ahalan", "Parev", "Zdravei", "Nei Ho", "Dobrý den", "Ahoj", "Goddag", "Goede dag, Hallo", "Hello", "Saluton", "Hei", "Bonjour",
          "Guten Tag", "Gia'sou", "Aloha", "Shalom", "Namaste", "Namaste", "Jó napot", "Halló", "Helló", "Góðan daginn", "Halo", "Aksunai", "Qanuipit", "Dia dhuit",
          "Salve", "Ciao", "Kon-nichiwa", "An-nyong Ha-se-yo", "Salvëte", "Ni hao", "Dzien' dobry", "Olá", "Bunã ziua", "Zdravstvuyte", "Hola", "Jambo", "Hujambo", "Hej",
          "Sa-wat-dee", "Merhaba", "Selam", "Vitayu", "Xin chào", "Hylo", "Sut Mae", "Sholem Aleychem", "Sawubona"};

  String [] colors = {"#EE82EE", "#00FF00", "#FF0000", "#0000FF","#FFFF00", " #FFCC00", "#CF0AF2"};


  @RequestMapping("/sayhello")
    public String sayHelloToAll(Model model){
    model.addAttribute("hello", hellos[(int)(Math.random() * (hellos.length) + 0)]);
    model.addAttribute("fontSize", (int)(Math.random() * 15 + 9));
    model.addAttribute("fontColor", colors[(int)(Math.random() * (colors.length) + 0)]);
    return "sayhello";
  }
}



