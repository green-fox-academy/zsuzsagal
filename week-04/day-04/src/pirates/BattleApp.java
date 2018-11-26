package pirates;

public class BattleApp {
    public static void main(String[] args) {
        // Create a BattleApp class with a main method
        // Create 2 ships, fill them with pirates
        // Have a battle!

        Pirate pirate1 = new Pirate();
        pirate1.howsItGoingMate();
        pirate1.drinkSomeRum();

        Pirate pirate2 = new Pirate();
        pirate2.brawl(pirate1);

        System.out.println(pirate1);
        System.out.println(pirate2);

        Ship shipOur1 = new Ship("Our Ship-1");
        shipOur1.fillShip();

        Ship shipOur2 = new Ship("Our Ship-2");
        shipOur2.fillShip();

        Ship shipOur3 = new Ship("Our Ship-3");
        shipOur3.fillShip();

        Ship shipOpp1 = new Ship("Opponent Ship-1");
        shipOpp1.fillShip();
        shipOpp1.captain.drinkSomeRum();
        shipOpp1.captain.drinkSomeRum();

        Ship shipOpp2 = new Ship("Opponent Ship-2");
        shipOpp2.fillShip();

        shipOur1.battle(shipOpp1);
        System.out.println(shipOur1);
        System.out.println(shipOpp1);
    }
}
