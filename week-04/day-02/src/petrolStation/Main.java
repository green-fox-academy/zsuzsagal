package petrolStation;

public class Main {
    public static void main(String[] args) {
        Station station1 = new Station(500);
        Car car1 = new Car();

        station1.refill(car1);
        System.out.println(station1);
        System.out.println(car1);
    }
}
