package animalFarm;

import java.util.ArrayList;

public class Farm {
//    it has list of Animals
//    it has slots which defines the number of free places for animals
//    breed() -> creates a new animal if there's place for it
//    slaughter() -> removes the least hungry animal

    public ArrayList<Animal> animals;
    int slot;


    public Farm(ArrayList<Animal> animals, int slot) {
        this.animals = animals;
        this.slot = slot;
    }

    public void add(Animal a) {
        animals.add(a);
    }

    public void breed() {
        if (slot > 0) {
            for (int i = 1; i < slot; i++) {
                Animal animalNew = new Animal("horse" + i, (int) (Math.random() * 30 + 1));
                animals.add(animalNew);
            }
        }
    }

    public void slaughter() {
        int leastHunger = animals.get(0).hunger;
        int indexOfLeastHunger = 0;

        for (int i = 1; i < animals.size(); i++) {
            if (animals.get(i).hunger <= leastHunger) {
                leastHunger = animals.get(i).hunger;
                indexOfLeastHunger = i;
            }
        }

        if (animals.get(indexOfLeastHunger).hunger == leastHunger) {
            System.out.println("The least hungry animal we removed is : " + animals.get(indexOfLeastHunger).name);
            animals.remove(animals.get(indexOfLeastHunger));
        }
    }
}


