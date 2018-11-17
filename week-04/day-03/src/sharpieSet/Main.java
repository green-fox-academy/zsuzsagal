package sharpieSet;

public class Main {
    public static void main(String[] args) {
        SharpieSet sharpieSet1 = new SharpieSet();

        Sharpie sharpieGreen = new Sharpie ("green", 0.25,75.5);
        Sharpie sharpieRed = new Sharpie ("red", 0.25,0);
        Sharpie sharpieBlue = new Sharpie ("blue", 0.65,40.8);
        Sharpie sharpieBlack = new Sharpie ("black", 0.25,0);
        Sharpie sharpiePurple = new Sharpie ("purple", 0.75,15);

        sharpieSet1.add(sharpieGreen);
        sharpieSet1.add(sharpieRed);
        sharpieSet1.add(sharpieBlue);
        sharpieSet1.add(sharpieBlack);
        sharpieSet1.add(sharpiePurple);

        sharpieSet1.countUsable();
        sharpieSet1.removeTrash();
    }
}
