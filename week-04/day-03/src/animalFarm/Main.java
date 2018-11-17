package animalFarm;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        Animal chicken = new Animal("chicken", 10);
        Animal duck = new Animal("duck", 22);
        Animal cow = new Animal("cow", 29);
        Animal rooster = new Animal("rooster", 27);

        ArrayList<Animal> animals = new ArrayList<>();
        animals.add(chicken);
        animals.add(duck);
        animals.add(cow);
        animals.add(rooster);

        Farm farmOne = new Farm(animals, 4);

        System.out.println("Animals and their initial hungers: " + animals);
        System.out.println("--------------------");

        duck.eat();
        cow.play();

        System.out.println("Animals and their hungers after eat and play : " + animals);
        System.out.println("--------------------");

        farmOne.breed();
        System.out.println("Animals and their hungers after calling breed(): " + animals);
        System.out.println("------------------");

        farmOne.slaughter();
        System.out.println("Animals and their hungers after deleting the least hungry animal : " + animals);
    }
}
