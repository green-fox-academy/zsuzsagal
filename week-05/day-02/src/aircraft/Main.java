package aircraft;

public class Main {
    public static void main(String[] args) {
        F16 F16_1 = new F16();
        F35 F35_1 = new F35();

        Carrier carrier1 = new Carrier(200, 3000);
        carrier1.add(F16_1);
        carrier1.add(F35_1);
        carrier1.fill();

        F16 F16_2 = new F16();
        F35 F35_2 = new F35();

        Carrier carrier2 = new Carrier(100, 2000);
        carrier2.add(F16_2);
        carrier2.add(F35_2);
        carrier2.fill();

        carrier1.fight(carrier2);
        System.out.println(carrier1.getStatus());
        System.out.println(carrier2.getStatus());
    }
}
