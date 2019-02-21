package gardenApp;

public class Tree extends Plants {
//    needs water if its current water amount is less then 10
//    when watering it the tree can only absorb the 40% of the water
//    eg. watering with 10 the tree's amount of water should only increase with 4

  public Tree(String color, int currentWaterLevel) {
    super("Tree", color, currentWaterLevel, 10, 0.4);
  }
}
