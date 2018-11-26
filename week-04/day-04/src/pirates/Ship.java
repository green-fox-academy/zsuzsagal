package pirates;

import java.util.ArrayList;

public class Ship {
//    The Ship stores Pirate-s instances in a list as the crew and has one captain who is also a Pirate.
//    When a ship is created it doesn't have a crew or a captain.
//    The ship can be filled with pirates and a captain via fillShip() method.
//    Filling the ship with a captain and random number of pirates.
//    Ships should be represented in a nice way on command line including information about
//    captains consumed rum, state (passed out / died)
//    number of alive pirates in the crew
//    Ships should have a method to battle other ships: ship.battle(otherShip)
//    should return true if the actual ship (this) wins
//    the ship should win if its calculated score is higher
//    calculate score: Number of Alive pirates in the crew - Number of consumed rum by the captain
//    The loser crew has a random number of losses (deaths).
//    The winner captain and crew has a party, including a random number of rum :)

    ArrayList<Pirate> listOfPirates;
    String nameOfShip;
    int score;
    Pirate captain;


    public Ship(String nameOfShip) {
        this.nameOfShip = nameOfShip;
        this.listOfPirates = new ArrayList<>();
    }


    public void fillShip() {
        int rand = (int) (Math.random() * 10 + 4);
        for (int i = 0; i < rand; i++) {
            Pirate p = new Pirate();
            listOfPirates.add(p);
        }
        captain = new Pirate();
        captain.isCaptain = true;

        this.listOfPirates.add(captain);
    }


    public int countAlive() {
        int count = 0;
        for (int i = 0; i < listOfPirates.size(); i++) {
            if (listOfPirates.get(i).isAlive) {
                count++;
            }
        }
        return count;
    }


    public int calculateScore() {
        score = countAlive() - captain.numberOfConsumedRum;
        if (score < 0) {
            score = 0;
        }
        return score;
    }


    public boolean battle(Ship s) {
        System.out.println("There is a battle between: " + this.nameOfShip + " and " + s.nameOfShip);

        Ship winner, looser;
        if (this.calculateScore() <= s.calculateScore()) {
            looser = this;
            winner = s;
        } else {
            looser = s;
            winner = this;
        }

        // loosers:
        int rand = (int) (Math.random() * looser.listOfPirates.size()) + 1;
        for (int i = 0; i < rand; i++) {
            looser.listOfPirates.get(i).die();
        }
        System.out.println(looser.nameOfShip + ", we have " + rand + " dead(s)!");

        // winners:
        int randForDrink = (int) (Math.random() * 20 + 1);
        System.out.println(winner.nameOfShip + "! Lets have a party and drink " + randForDrink + " rum(s)!");
        winner.captain.drinkSomeRum();
        winner.captain.drinkSomeRum();
        System.out.println(winner.toString());

        System.out.print("Is our ship the winner? ");
        System.out.println(this == winner);
        System.out.println("---------------------------");

        return (this == winner);
    }


    public String toString() {
        return nameOfShip + ": alive " + countAlive() + ", "
                + "score " + calculateScore() +
                ", captain's got " + captain.numberOfConsumedRum + " rum(s).";
    }
}
