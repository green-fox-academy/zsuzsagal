import java.util.*;

public class Matchmaking {
    public static void main(String... args) {
        ArrayList<String> girls = new ArrayList<String>(Arrays.asList("Eve", "Ashley", "Claire", "Kat", "Jane"));
        ArrayList<String> boys = new ArrayList<String>(Arrays.asList("Joe", "Fred", "Tom", "Todd", "Neef", "Jeff"));

        // Write a method that joins the two lists by matching one girl with one boy into a new list
        // Exepected output: "Eve", "Joe", "Ashley", "Fred"...

        System.out.println(makingMatches(girls, boys));
    }

    public static ArrayList<String> makingMatches(ArrayList<String> inputA, ArrayList<String> inputB) {

        ArrayList<String> concated = new ArrayList<String>();

        if (inputA.size() < inputB.size()) {
            for (int i = 0; i < inputA.size(); i++) {
                concated.add(inputA.get(i));
                concated.add(inputB.get(i));
            }
            concated.add(concated.size(), inputB.get(inputB.size() - 1));

        } else if (inputA.size() > inputB.size()) {
            for (int i = 0; i < inputB.size(); i++) {
                concated.add(inputA.get(i));
                concated.add(inputB.get(i));
            }
            concated.add(concated.size(), inputA.get(inputA.size() - 1));
        }

        return concated;
    }
}
