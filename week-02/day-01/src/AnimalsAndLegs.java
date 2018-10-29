import java.util.Scanner;

public class AnimalsAndLegs {
    public static void main(String[] args) {
        // Write a program that asks for two integers
        // The first represents the number of chickens the farmer has
        // The second represents the number of pigs owned by the farmer
        // It should print how many legs all the animals have


        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter the number of chickens: ");
        int numberOfChickens = sc.nextInt();
        System.out.println("Please enter the number of pigs: ");
        int numberOfPigs = sc.nextInt();

        int allLegs = (numberOfChickens * 2) + (numberOfPigs * 4);
        System.out.println(allLegs);
    }
}
