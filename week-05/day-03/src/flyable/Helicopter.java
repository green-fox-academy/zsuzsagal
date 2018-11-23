package flyable;

public class Helicopter extends Vehicle implements Flyable {
    //    Extend Helicopter class from Vehicle
    //    implement your Flyable interface

    public Helicopter() {
        super();
    }

    @Override
    public void land() {
        System.out.println("Helicopter is landing.");
    }

    @Override
    public void fly() {
        System.out.println("Helicopter is flying.");
    }

    @Override
    public void takeOff() {
        System.out.println("Helicopter is taking off.");
    }
}
