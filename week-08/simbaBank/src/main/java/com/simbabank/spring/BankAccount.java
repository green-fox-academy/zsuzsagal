package com.simbabank.spring;

public class BankAccount {
  private String name;
  private double balance;
  private String animalType;
  private String king;

  public BankAccount(String name, double balance, String animalType, String king) {
    this.name = name;
    this.balance = balance;
    this.animalType = animalType;
    this.king = king;
  }

  public String getName() {
    return name;
  }

  public double getBalance() {
    return balance;
  }

  public String getAnimalType() {
    return animalType;
  }

  public String getKing() {
    return king;
  }

  public void raiseAccount() {
    if (king.equalsIgnoreCase("King")) {
      balance += 100;
    } else {
      balance += 10;
    }
  }
}
