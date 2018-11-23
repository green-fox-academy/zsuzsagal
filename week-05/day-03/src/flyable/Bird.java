package flyable;

public class Bird extends Animal implements Flyable {
    //    Extend Bird from your abstract Animal class (zoo exercise)
    //    implement yourˇFlyable interface

    @Override
    public void land() {
        System.out.println("Bird is landing.");
    }

    @Override
    public void fly() {
        System.out.println("Bird is flying.");
    }

    @Override
    public void takeOff() {
        System.out.println("Bird is taking off.");
    }
}
