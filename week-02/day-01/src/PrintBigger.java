import java.util.Scanner;

public class PrintBigger {

    public static void main(String[] args) {
        // Write a program that asks for two numbers and prints the bigger one

        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter a number: ");
        int numberA = sc.nextInt();
        System.out.println("Please enter another number: ");
        int numberB = sc.nextInt();

        if(numberA > numberB) {
            System.out.println(numberA);
        } else if (numberA < numberB){
            System.out.println(numberB);
        } else {
            System.out.println("the numbers are equal");
        }

    }
}
