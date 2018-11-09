import java.util.Scanner;

public class HelloUser {
    public static void main(String[] args) {
        // Modify this program to greet user instead of the World!
        // The program should ask for the name of the user

        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter your name: ");
        String inputName = sc.nextLine();
        System.out.println("Hello " + inputName + "!");
    }
}
