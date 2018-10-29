import java.util.Scanner;

public class MileToKmConverter {
    public static void main(String[] args) {
        // Write a program that asks for an integer that is a distance in kilometers,
        // then it converts that value to miles and prints it

        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter a distance in km: ");
        int km = sc.nextInt();
        double miles = km * 0.62137;

        System.out.println(miles);


    }

}
