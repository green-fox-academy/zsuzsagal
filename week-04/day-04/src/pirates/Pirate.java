package pirates;

public class Pirate {
//    drinkSomeRum() - intoxicates the Pirate some
//    howsItGoingMate() - when called, the Pirate replies:
//      if drinkSomeRun was called: // count how many times was drinkSomeRum called
//     - 0 to 4 times, "Pour me anudder!"
//     - else, "Arghh, I'ma Pirate. How d'ya d'ink its goin?", the pirate passes out and sleeps it off.

//   If you manage to get this far, then you can try to do the following:
//    - die() - this kills off the pirate, in which case, drinkSomeRum, etc. just result in he's dead.
//    - brawl(x) - where pirate fights another pirate (if that other pirate is alive) and there's a 1/3 chance,
//    1 dies, the other dies or they both pass out.

    boolean isAlive;
    boolean isCaptain;
    int numberOfConsumedRum;

    public Pirate() {
        this.isAlive = true;
        this.isCaptain = false;
        this.numberOfConsumedRum = 0;
    }

    public void drinkSomeRum() {
        numberOfConsumedRum++;
    }

    public void howsItGoingMate() {
        if (numberOfConsumedRum > 4) {
            System.out.println("Arghh, I'ma Pirate. How d'ya d'ink its goin?");
        } else if (numberOfConsumedRum <= 4) {
            System.out.println("Pour me anudder!");
        }
    }

    public void die() {
        isAlive = false;
    }

    public void brawl(Pirate p) {
        if (this.isAlive && p.isAlive) {
            double chance = Math.random();
            if (chance < 0.3) {
                System.out.println("I am dying.");
                die();
            } else if (chance < 0.6) {
                p.die();
                System.out.println("the other pirot died!");
            } else {
                die();
                p.die();
                System.out.println("both pirots are dead.");
            }
        }
    }

    public String toString() {
        if (isAlive) {
            if (numberOfConsumedRum <= 4) {
                return "alive, rum consumed: " + this.numberOfConsumedRum;
            } else {
                return "passed out";
            }
        }
        return "he's dead";
    }
}