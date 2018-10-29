import java.util.Scanner;

public class AverageOfInput {

    public static void main(String[] args) {
        // Write a program that asks for 5 integers in a row,
        // then it should print the sum and the average of these numbers like:
        //
        // Sum: 22, Average: 4.4

        Scanner sc = new Scanner(System.in);

        int sum = 0;
        int average = 0;

        for(int i=1; i<6; i++){
            System.out.println("Please enter a number: ");
            int number = sc.nextInt();
            sum+=number;
            average=sum/i;
        }

        System.out.println(sum);
        System.out.println(average);

    }
}
