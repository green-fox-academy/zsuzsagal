package com.fox.spring;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
public class MainController {
  private List<Fox> foxes;

  public MainController() {
    foxes = new ArrayList<>();

    foxes.add(new Fox("Vuk", "fried chicken", "water", Arrays.asList("Java", "Javascript", "Json", "SQL")));
    foxes.add(new Fox("Karak", "fried potato", "wine", Arrays.asList("C#", "C++", "Python")));
    foxes.add(new Fox("Little fox", "egg", "tea", Arrays.asList("PHP", "Perl")));
    foxes.add(new Fox("Mr Green", "salad", "water", Arrays.asList()));
  }

  public List<Fox> getFoxes() {
    return foxes;
  }

  @GetMapping("/")
  public String intro(Model model, @RequestParam(value = "name", required = false) String name) {
    Fox fox = getFoxByName(name);
    if (fox == null) {
      return "redirect:/login";
    } else {
      model.addAttribute("fox", fox);
      return "index";
    }
  }

  private Fox getFoxByName(@RequestParam(value = "name", required = false) String name) {
    return foxes.stream()
            .filter(foxes -> foxes.getName().equals(name))
            .findFirst()
            .orElse(null);
  }


  @GetMapping("login")
  public String login() {
    return "login";
  }

  @PostMapping("login")
  public String getFoxName(@RequestParam(value = "name") String foxName) {
    return "redirect:/?name=" + foxName;
  }

  public List<String> allPossibleFoods() {
    return Arrays.asList("roasted beef", "hamburger", "fish sticks", "corn beef");
  }

  public List<String> allPossibleDrinks() {
    return Arrays.asList("juice", "coffee", "Coke", "apple cider");
  }

  @GetMapping("/nutritionStore")
  public String nutrition(Model model, @RequestParam(value = "name", required = false) String foxName) {
    Fox fox = getFoxByName(foxName);
    model.addAttribute("fox", fox);
    model.addAttribute("allPossibleFoods", allPossibleFoods());
    model.addAttribute("allPossibleDrinks", allPossibleDrinks());
    return "nutritionStore";
  }

  @PostMapping("/nutritionStore")
  public String nutrition(Model model, @ModelAttribute(value = "fox") Fox fox) {
    Fox originalFox = getFoxByName(fox.getName());
    originalFox.setFood(fox.getFood());
    originalFox.setDrink(fox.getDrink());
    return "redirect:/?name=" + originalFox.getName();
  }
}
