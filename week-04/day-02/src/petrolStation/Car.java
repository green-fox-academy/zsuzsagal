package petrolStation;

public class Car {

//    gasAmount
//    capacity
//    create constructor for Car where:
//    initialize gasAmount -> 0
//    initialize capacity -> 100

    private int gasAmount;
    private int capacity;

    public Car() {
        this.gasAmount = 0;
        this.capacity = 100;
    }

    public int getGasAmount() {
        return gasAmount;
    }

    public void setGasAmount(int gasAmount) {
        this.gasAmount = gasAmount;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public String toString() {
        return "The amount of gas in the car is: " + this.gasAmount + ", the capacity is: " + this.capacity;
    }
}
