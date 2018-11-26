package aircraft;

import java.util.ArrayList;

public class Carrier {
//    The carrier should be able to store aircrafts
//    Each carrier should have a store of ammo represented as number
//    The initial ammo should be given by a parameter in it's constructor
//    The carrier also has a health point given in it's constructor as well

    ArrayList<Aircraft> aircrafts;
    int storeOfAmmo;
    int healthPoint;

    public Carrier(int storeOfAmmo, int healthPoint) {
        aircrafts = new ArrayList<>();
        this.storeOfAmmo = storeOfAmmo;
        this.healthPoint = healthPoint;
    }

    public void add(Aircraft a) {
        aircrafts.add(a);
    }

    public void fill() {
        int totalNeedOfAmmo = 0;
        for (Aircraft x : aircrafts) {
            totalNeedOfAmmo += x.neededAmmo();
        }
        if (storeOfAmmo >= totalNeedOfAmmo) {
            for (Aircraft x : aircrafts) {
                storeOfAmmo = x.refill(storeOfAmmo);
            }
        } else {
            for (Aircraft x : aircrafts) {
                if (x.isPriority()) {
                    storeOfAmmo = x.refill(storeOfAmmo);
                }
            }
        }
    }


    public void fight(Carrier carrier) {
        int countAmmo = 0;

        for (Aircraft aircraft : aircrafts) {
            countAmmo += aircraft.ammo * aircraft.baseDamage;
            aircraft.ammo = 0;
        }
        carrier.healthPoint -= countAmmo;
    }

//    getStatus
//    It should give back a string about it's and all of its aircrafts status like:
//    HP: 5000, Aircraft count: 4, Ammo Storage: 2300, Total damage: 2280
//    Aircrafts:
//    Type F35, Ammo: 12, Base Damage: 50, All Damage: 600
//    Type F35, Ammo: 12, Base Damage: 50, All Damage: 600
//    Type F35, Ammo: 12, Base Damage: 50, All Damage: 600
//    Type F16, Ammo: 8, Base Damage: 30, All Damage: 240
//    Type F16, Ammo: 8, Base Damage: 30, All Damage: 240

    public String getStatus() {
        int totalDamage = 0;
        String status = "";
        for (Aircraft aircraft : aircrafts) {
            totalDamage += aircraft.allDamage();
        }

        status = "HP: " + healthPoint + ", " + "Aircraft count: " + aircrafts.size() + ", Ammo Storage: " + storeOfAmmo + ", Total Damage:" + totalDamage + "\n";
        status += "Aircrafts:\n";
        for (Aircraft aircraft : aircrafts) {
            status += aircraft.getStatus() + "\n";
        }
        return status;
    }
}


