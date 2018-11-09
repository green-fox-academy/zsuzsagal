import java.util.Random;
import java.util.Scanner;

public class GuessMyNumber {
    public static void main(String[] args) {
//        Write a program where the program chooses a number between 1 and 100.
//        The player is then asked to enter a guess. If the player guesses wrong,
//        then the program gives feedback and ask to enter an other guess until the guess is correct.
//
//        Make the range customizable (ask for it before starting the guessing).
//        You can add lives. (optional)
//        Example:
//        I've the number between 1-100. You have 5 lives.
//        20
//        Too high. You have 4 lives left.
//        10
//        Too low. You have 3 lives left.
//        15
//        Congratulations. You won!

        Scanner sc = new Scanner(System.in);

        System.out.println("We are going to play a guess game.\nPlease enter the lowest value for the range: ");
        int startOfRange = sc.nextInt();
        System.out.println("Please enter the highest value for the range: ");
        int endOfRange = sc.nextInt();

        int numberToGuess = (int) (Math.random() * ((endOfRange - startOfRange) + 1)) + startOfRange;

        System.out.println("the number to guess: " + numberToGuess);

        int guess;
        System.out.println("I have the number between " + startOfRange + " and " + endOfRange);

        System.out.println("You have 3 lives, go for it !");
        int lives = 3;

        do {
            System.out.println("Please enter your guess: ");
            guess = sc.nextInt();

            if (guess <= startOfRange || guess >= endOfRange) {
                System.out.println("Your guess is out of range.");
            } else if (guess > numberToGuess) {
                lives--;
                System.out.println("Too high. You have " + lives + " lives left.");
            } else if (guess < numberToGuess) {
                lives--;
                System.out.println("Too low. You have " + lives + " lives left.");
            } else {
                System.out.println("Congratulations. You won!");
            }

        } while (guess != numberToGuess && lives > 0);

        if (lives == 0) {
            System.out.println("You have no more lives. The number was: " + numberToGuess);
        }
    }
}




