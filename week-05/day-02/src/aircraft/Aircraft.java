package aircraft;

public class Aircraft {
//    Create a class that represents an aircraft
//    There are 2 types of aircrafts: F16 and F35
//    Both aircraft should track how many ammo it has
//    All the aircrafts should be created with empty ammo store
//    Methods:
//    fight()
//    It should use all the ammos (set it to 0) and it should return the damage it deals
//    The damage is the multiplication of the base damage and the ammos

//    refill()
//    It should take a number as parameter and substract as much ammo as possibe
//    It can't have more ammo than the number or the max ammo (can't get more ammo than what's coming from the parameter or the max ammo of the aircraft)
//    It should return the remaining ammo
//    Eg. Filling an empty F35 with 300 would completely fill the storage of the aircraft and would return the remaining 288

//    getType()
//    It should return it's type as a string

//    getStatus()
//    It should return a string like: Type F35, Ammo: 10, Base Damage: 50, All Damage: 500
//    isPriority
//    It should return if the aircraft is priority in the ammo fill queue. It's true for F35 and false for F16

    String type;
    int ammo;
    int maxAmmo;
    int baseDamage;

    public Aircraft(String type, int maxAmmo, int baseDamage) {
        this.type = type;
        this.ammo = 0;
        this.maxAmmo = maxAmmo;
        this.baseDamage = baseDamage;
    }

    public int allDamage() {
        return baseDamage * ammo;
    }


    public int fight() {
        int allDamage = allDamage();
        ammo = 0;
        return allDamage;
    }



    public int refill(int number) {
        if (number >= maxAmmo - ammo) {
            int returnAmmo = number - (maxAmmo - ammo);
            ammo = maxAmmo;
            return returnAmmo;
        } else {
            ammo = ammo + number;
            return 0;
        }
    }

    public int neededAmmo() {
        return maxAmmo - ammo;
    }

    public String getType() {
        return type;
    }

    public String getStatus() {
        return "Type " + type + ",  Ammo: " + ammo + ",  Base Damage: " + baseDamage
                + ",  All Damage: " + baseDamage * ammo;
    }

    public boolean isPriority() {
        return false;
    }
}




