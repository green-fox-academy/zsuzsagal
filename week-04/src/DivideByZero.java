public class DivideByZero {
    public static void main(String[] args) {
        // Create a function that takes a number
        // divides ten with it,
        // and prints the result.
        // It should print "fail" if the parameter is 0

        dividesTen(0);
    }


    // would be better to use double for the division, but double can not catch ArithmeticException.
    public static void dividesTen(int number) {
        try {
            System.out.println(10 / number);
        } catch (ArithmeticException e) {
            System.out.println("fail");
        }
    }
}