package gardenApp;

public class Plants {
  String name;
  String color;
  double currentWaterLevel;
  int minWaterNeed;
  double absorbWater;

  public Plants(String name, String color, int currentWaterLevel, int minWaterNeed, double absorbWater) {
    this.name = name;
    this.color = color;
    this.currentWaterLevel = currentWaterLevel;
    this.minWaterNeed = minWaterNeed;
    this.absorbWater = absorbWater;
  }

  public String needsWater() {
    String isWaterNeeded = "";
    if (currentWaterLevel < minWaterNeed) {
      isWaterNeeded = "The " + this.color + " " + name + " needs water.";
    } else {
      isWaterNeeded = "The " + this.color + " " + name + " does not need water.";
    }
    return isWaterNeeded;
  }

  public void watering(int water) {
    currentWaterLevel += water * absorbWater;
    System.out.println("The current water level of the " + this.color + " " + name + " is: " + currentWaterLevel);
  }
}
