package com.greenfoxacademy.webshop.models;

public class ShopItem {

  private String name;
  private String description;
  private double price;
  private int quantityOfStock;

  public ShopItem(){
  }

  public ShopItem(String name, String description, double price, int quantityOfStock) {
    this.name = name;
    this.description = description;
    this.price = price;
    this.quantityOfStock = quantityOfStock;
  }


  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public double getPrice() {
    return price;
  }

  public void setPrice(double price) {
    this.price = price;
  }

  public int getQuantity() {
    return quantityOfStock;
  }

  public void setQuantity(int quantity) {
    this.quantityOfStock = quantity;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String toString(){
    return name + " " + description + " " + price + " " + quantityOfStock;
  }

}


