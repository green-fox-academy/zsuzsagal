package com.greenfoxacademy.webshop.models;

import java.util.ArrayList;

public class WebShop {

  private ArrayList<ShopItem> shopItems;

  public WebShop(ArrayList<ShopItem> shopItems) {
    this.shopItems = shopItems;
  }

  public WebShop() {

    this.shopItems = new ArrayList<>();

    this.shopItems.add(new ShopItem("Running Shoes", "Nike running shoes for everyday sport", 1000, 5));
    this.shopItems.add(new ShopItem("Printer", "Some HP printer that will print pages", 3000, 2));
    this.shopItems.add(new ShopItem("Coca cola", "0.5l standard Coke", 25, 0));
    this.shopItems.add(new ShopItem("Wokin", "Chicken with fried rice and WOKIN sauce", 119, 100));
    this.shopItems.add(new ShopItem("T-shirt", "Blue with a corgi on a bike", 300, 1));
  }

  public ArrayList<ShopItem> getShopItems() {
    return shopItems;
  }

}


