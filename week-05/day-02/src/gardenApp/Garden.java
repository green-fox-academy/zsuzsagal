package gardenApp;

import java.util.ArrayList;

public class Garden {
  public static void main(String... args) {
//  is able to hold unlimited amount of flowers or trees
//  when watering, it should only water those what needs water with equally divided amount amongst them
//  eg. watering with 40 and 4 of them need water then each gets watered with 10

    ArrayList<Plants> plants = new ArrayList<>();

    Flower yellowFlower = new Flower("yellow", 6);
    plants.add(yellowFlower);
    Flower blueFlower = new Flower("blue", 2);
    plants.add(blueFlower);
    Tree purpleTree = new Tree("purple", 11);
    plants.add(purpleTree);
    Tree orangeTree = new Tree("orange", 8);
    plants.add(orangeTree);

    for (int i = 0; i < plants.size(); i++) {

      System.out.print(plants.get(i).needsWater() + " ");
      System.out.println("Current water level is: " + plants.get(i).currentWaterLevel);
    }
    waterGarden(40, plants);
  }

  public static void waterGarden(int totalWaterQty, ArrayList<Plants> plants) {
    int countNeedsWater = 0;
    for (int i = 0; i < plants.size(); i++) {
      if (plants.get(i).currentWaterLevel < plants.get(i).minWaterNeed) {
        countNeedsWater++;
      }
    }
    for (int i = 0; i < plants.size(); i++) {
      if (plants.get(i).currentWaterLevel < plants.get(i).minWaterNeed) {
        plants.get(i).watering(totalWaterQty / countNeedsWater);
      }
    }
  }
}
