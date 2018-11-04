import java.util.Scanner;

public class DrawChessTable {
    public static void main(String[] args) {
        // Create a program that draws a chess table like this:
        // % % % %
        //  % % % %
        // % % % %
        //  % % % %
        // % % % %
        //  % % % %
        // % % % %
        //  % % % %

        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter a number: ");
        int number = sc.nextInt();


        for (int row = 1; row<= number; row++) {
            for(int column = 1; column <=number; column++){
                if ((row%2==0 && column%2==0) || (row%2!=0 && column%2!=0)){
                    System.out.print("%");
                }
                else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }
}
