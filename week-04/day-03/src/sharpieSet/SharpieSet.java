package sharpieSet;

import java.util.ArrayList;

public class SharpieSet {
    //    Create SharpieSet class
    //    it contains a list of Sharpie
    //    countUsable() -> sharpie is usable if it has ink in it
    //    removeTrash() -> removes all unusable sharpies


    public ArrayList<Sharpie> sharpies = new ArrayList<>();

    public void add(Sharpie sharpie) {
        sharpies.add(sharpie);
    }

    public int countUsable() {
        int counter = 0;
        for (int i = 0; i < this.sharpies.size(); i++) {
            if (this.sharpies.get(i).inkAmount > 0) {
                counter++;
            }
        }
        System.out.println("Number of usable sharpies: " + counter);
        return counter;
    }


    public int removeTrash() {
        int counter = 0;
        for (int i = 0; i < this.sharpies.size(); i++) {
            if (this.sharpies.get(i).inkAmount == 0)
                counter++;
        }
        System.out.println("Number of trashed sharpies: " + counter);
        return counter;
    }
}
