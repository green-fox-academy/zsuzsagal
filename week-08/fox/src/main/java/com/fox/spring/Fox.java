package com.fox.spring;

import java.util.List;

public class Fox {
  private String name;
  private String food;
  private String drink;
  private List<String> tricks;

  public Fox(String name, String food, String drink, List<String> tricks) {
    this.name = name;
    this.food = food;
    this.drink = drink;
    this.tricks = tricks;
  }

  public String getName() {
    return name;
  }

  public String getFood() {
    return food;
  }

  public String getDrink() {
    return drink;
  }

  public List<String> getTricks() {
    return tricks;
  }

  public void addTrick(String trick) {
    tricks.add(trick);
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setFood(String food) {
    this.food = food;
  }

  public void setDrink(String drink) {
    this.drink = drink;
  }

  public void setTricks(List<String> tricks) {
    this.tricks = tricks;
  }
}



