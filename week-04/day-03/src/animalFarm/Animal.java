package animalFarm;

public class Animal {
//    Create an Animal class
//    Every animal has a hunger value, which is a whole number
//    Every animal has a thirst value, which is a whole number
//    when creating a new animal object these values are created with the default 50 value
//    Every animal can eat() which decreases their hunger by one
//    Every animal can drink() which decreases their thirst by one
//    Every animal can play() which increases both by one

    String name;
    int hunger;

    public Animal(String name) {
        this.name = name;
    }

    public Animal(String name, int hunger) {
        this.name = name;
        this.hunger = hunger;
    }

    public void eat() {
        hunger -= 1;
    }

    public void play() {
        hunger += 2;
    }

    @Override
    public String toString() {
        return this.name + " hunger: " + this.hunger;
    }
}
