import java.util.Scanner;

public class GuessTheNumber {
    public static void main(String[] args) {
        // Write a program that stores a number, and the user has to figure it out.
        // The user can input guesses, after each guess the program would tell one
        // of the following:
        //
        // The stored number is higher
        // The stried number is lower
        // You found the number: 8


        int number = 8;
        Scanner sc = new Scanner(System.in);
        int guess = 0;

        do {
            System.out.println("Please enter your guess: ");
            guess = sc.nextInt();

            if (guess > 8) {
                System.out.println("The stored number is lower");
            } else if (guess < 8) {
                System.out.println("The stored number is higher");
            } else {
                System.out.println("You found the number: " + number);
            }
        } while (guess != number);
    }
}
