package pirates;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Random;

public class Armada {
    public static final Random RANDOM = new Random();
// Contains Ship-s as a list
// Have a armada.war(otherArmada) method where two armada can engage in war
// it should work like merge sort
// first ship from the first armada battles the first of the other
// the loser gets skipped so the next ship comes in play from that armada
// whichever armada gets to the end of its ships loses the war
// return true if this is the winner

    ArrayList<Ship> listOfShips;
    String nameOfArmada;

    public Armada(String nameOfArmada) {
        this.nameOfArmada = nameOfArmada;
        this.listOfShips = new ArrayList<>();
    }

    public void fillArmada() {
        int rand = RANDOM.nextInt(5) + 2;
        for (int i = 0; i < rand; i++) {
            Ship s = new Ship(nameOfArmada + "-Ship No:" + Integer.toString(i));
            this.listOfShips.add(s);
            s.fillShip();
        }
    }


    public boolean war(Armada a) {

        while (this.listOfShips.size() != 0 && a.listOfShips.size() != 0) {
            if (this.listOfShips.get(0).battle(a.listOfShips.get(0))) {
                a.listOfShips.remove(0);
            } else {
                this.listOfShips.remove(0);
            }
        }

        System.out.print("OUR ARMADA IS THE WINNER? ");
        System.out.println(this.listOfShips.size() != 0);
        return this.listOfShips.size() != 0;
    }


    public void printArmadaStatus() {
        for (int i = 0; i < listOfShips.size(); i++) {
            Ship s = listOfShips.get(i);
            System.out.println(s.toString());
        }
        System.out.println("=============================================");
    }
}