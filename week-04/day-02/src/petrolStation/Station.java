package petrolStation;

public class Station {
//    gasAmount
//    refill(car) -> decreases the gasAmount by the capacity of the car and increases the cars gasAmount

    private int gasAmount;

    public Station(int gasAmount) {
        this.gasAmount = gasAmount;
    }

    public void refill(Car c) {
        this.gasAmount -= (c.getCapacity()-c.getGasAmount());
        c.setGasAmount(c.getCapacity()-c.getGasAmount());
    }

    public String toString() {
        return "The amount of gas at the gas station is: " + this.gasAmount;
    }
}
