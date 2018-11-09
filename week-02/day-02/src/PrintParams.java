public class PrintParams {
    public static void main(String[] args) {
        // - Create a function called `printParams`
        //   which prints the input String parameters
        // - It can have any number of parameters

        // Examples
        // printParams("first")
        // printParams("first", "second")
        // printParams("first", "second", "third", "fourth")
        // ...

        printParams("first");
        printParams("first", "second");
        printParams("first", "second", "third");
        printParams("first", "second", "third", "fourth");
    }

    public static void printParams(String... words) {
        for (int i = 0; i < words.length; i++) {
            System.out.print(words[i] + " ");
        }
        System.out.println("\n");
    }
}

