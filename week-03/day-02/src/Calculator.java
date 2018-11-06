import java.util.Scanner;

public class Calculator {
    public static void main(String... args) {
//        Create a simple calculator application which reads the parameters from the prompt
//        and prints the result to the prompt.
//        It should support the following operations,
//        create a method named "calculate()":
//        +, -, *, /, % and it should support two operands.
//        The format of the expressions must be: {operation} {operand} {operand}.
//        Examples: "+ 3 3" (the result will be 6) or "* 4 4" (the result will be 16)
//
//        You can use the Scanner class
//        It should work like this:
//
//        Start the program
//        It prints: "Please type in the expression:"
//        Waits for the user input
//        Print the result to the prompt
//        Exit

        System.out.println(calculate());
    }

    public static int calculate() {

        Scanner sc = new Scanner(System.in);
        System.out.println("Please type in the expression:");

        String expression = sc.nextLine();
        String[] splitExpression = expression.split(" ");

        String operator = splitExpression[0];
        int operandA = Integer.parseInt(splitExpression[1]);
        int operandB = Integer.parseInt(splitExpression[2]);

        int result = 0;

        switch (operator) {

            case "+":
                result = operandA + operandB;
                break;

            case "-":
                result = operandA - operandB;
                break;

            case "*":
                result = operandA * operandB;
                break;

            case "/":
                result = operandA / operandB;
                break;

            case "%":
                result = operandA % operandB;
                break;
        }
        return result;
    }
}