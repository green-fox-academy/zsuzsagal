
import java.util.Scanner;

public class DrawPyramid {
    public static void main(String[] args) {
        // Write a program that reads a number from the standard input, then draws a
        // pyramid like this:
        //
        //
        //    *
        //   ***
        //  *****
        // *******
        //
        // The pyramid should have as many lines as the number was

        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter a number: ");
        int number = sc.nextInt();

        int countSpaces = number-1;
        int countAsterisks = 1;

        for (int row = 1; row<= number; row++) {
            for (int space = 1; space <=countSpaces; space++) {
                System.out.print(" ");
            }
            for(int asterisk = 1; asterisk <= countAsterisks; asterisk++){
                System.out.print("*");

            }

            countSpaces--;
            countAsterisks+=2;
            System.out.println();
        }
    }
}
