import java.util.Scanner;

public class ParametricAverage {
    public static void main(String[] args) {
        // Write a program that asks for a number.
        // It would ask this many times to enter an integer,
        // if all the integers are entered, it should print the sum and average of these
        // integers like:
        //
        // Sum: 22, Average: 4.4

        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter the count: ");
        int count = sc.nextInt();

        int sum = 0;
        double average = 0;

        for (int i = 1; i <= count; i++) {
            System.out.println("Please enter a number: ");
            int number = sc.nextInt();
            sum += number;
        }

        average = sum / count;

        System.out.println(sum);
        System.out.println(average);
    }
}
