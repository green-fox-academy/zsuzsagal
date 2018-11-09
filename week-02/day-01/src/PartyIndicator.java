import java.util.Scanner;

public class PartyIndicator {
    public static void main(String[] args) {
        // Write a program that asks for two numbers
        // The first number represents the number of girls that comes to a party, the
        // second the boys
        // It should print: The party is excellent!
        // If the the number of girls and boys are equal and 20 or more people are coming to the party
        //
        // It should print: Average party...
        // If there are less people coming than 20
        //
        // It should print: Sausage party
        // If no girls are coming, regardless the count of the people

        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter the number of girls coming to the party: ");
        int numberOfGirls = sc.nextInt();
        System.out.println("Please enter the number of boys: ");
        int numberOfBoys = sc.nextInt();

        if (numberOfGirls < 1) {
            System.out.println("Sausage party");
        } else if ((numberOfGirls == numberOfBoys) && (numberOfBoys + numberOfGirls) > 20) {
            System.out.println("The party is excellent!");
        } else if ((numberOfGirls != numberOfBoys) && (numberOfBoys + numberOfGirls) > 20) {
            System.out.println("Quite cool party!");
        } else if ((numberOfBoys + numberOfGirls) <= 20) {
            System.out.println("Average party...");
        }
    }
}
