public class SwapElements {
    public static void main(String[] args) {
        // - Create an array variable named `abc`
        //   with the following content: `["first", "second", "third"]`
        // - Swap the first and the third element of `abc`

        String[] abc = {"first", "second", "third"};
        String temp;
        temp = abc[0];
        abc[0] = abc[abc.length-1];
        abc[abc.length-1] = temp;

        for (int i = 0; i < abc.length; i++) {
            System.out.print(abc[i] + " ");

        }
    }
}
