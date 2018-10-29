import java.sql.SQLOutput;

public class TwoNumbers {
    public static void main(String[] args) {
        // Create a program that prints a few operations on two numbers: 22 and 13
        // Print the result of 13 added to 22
        // Print the result of 13 substracted from 22
        // Print the result of 22 multiplied by 13
        // Print the result of 22 divided by 13 (as a decimal fraction)
        // Print the integer part of 22 divided by 13
        // Print the reminder of 22 divided by 13

        int numberA = 22;
        int numberB = 13;

        int addition = numberA + numberB;
        int subtraction = numberA - numberB;
        int multiplication = numberA * numberB;
        double division = (double)numberA / numberB;
        int divisionInt = numberA / numberB;
        int remainder = numberA % numberB;

        System.out.println(addition);
        System.out.println(subtraction);
        System.out.println(multiplication);
        System.out.println(division);
        System.out.println(divisionInt);
        System.out.println(remainder);

    }
}
