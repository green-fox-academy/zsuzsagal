package com.greenfoxacademy.webshop.controllers;

import com.greenfoxacademy.webshop.models.ShopItem;
import com.greenfoxacademy.webshop.models.WebShop;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Controller
public class WebShopControllers {

    WebShop wb1 = new WebShop();

    @GetMapping("/home")
    public String getAll(Model model) {
      model.addAttribute("allProducts", wb1.getShopItems());
      return "myShop";
    }


    @GetMapping("/only-available")
    public String getAvailable(Model model) {
      model.addAttribute("allProducts",wb1.getShopItems().stream()
              .filter(item -> item.getQuantity() > 0 )
              .collect(Collectors.toList()));
      return "myShop";
    }


    @GetMapping("/cheapest-first")
    public String getCheapestFirst (Model model){
      model.addAttribute("allProducts", wb1.getShopItems().stream()
              .sorted(Comparator.comparing(ShopItem::getPrice))
              .collect(Collectors.toList()));
      return "myShop";
    }


    @GetMapping("/most-expensive")
    public String getMostExpensive(Model model) {
      model.addAttribute("allProducts", wb1.getShopItems().stream()
              .max(Comparator.comparing(ShopItem::getPrice))
              .orElseThrow(NoSuchElementException::new));
      return "myShop";
    }


    @GetMapping("/average")
    public String getAverage(Model model) {
      model.addAttribute("average", wb1.getShopItems().stream()
              .mapToDouble(ShopItem::getQuantity)
              .average()
              .orElseThrow(NoSuchElementException::new));
      return "averageStock";
    }


    @GetMapping("/contains-nike")
    public String getContainsString(Model model) {
        model.addAttribute("allProducts",wb1.getShopItems().stream()
  //            .filter(item -> item.getName().contains("Nike") || item.getDescription().contains("Nike"))
                .filter(item -> item.toString().contains("Nike"))
              .collect(Collectors.toList()));
      return "myShop";
    }


    @RequestMapping("/search")
    public String searchElements (Model model, @RequestParam(value = "searchText", defaultValue = "nike") final String text) {
      List<ShopItem> result = wb1.getShopItems()
              .stream()
              .filter( p -> p.getDescription().toLowerCase().contains( text.toLowerCase() ) || p.getName().toLowerCase().contains( text.toLowerCase() ) )
              .collect(Collectors.toList() );
      model.addAttribute( "allProducts", result );
      return "myShop";
    }

}















