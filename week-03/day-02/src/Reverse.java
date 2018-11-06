public class Reverse {
    public static void main(String... args) {
        String reversed = ".eslaf eb t'ndluow ecnetnes siht ,dehctiws erew eslaf dna eurt fo sgninaem eht fI";

        // Create a method that can reverse a String, which is passed as the parameter
        // Use it on this reversed string to check it!
        // Try to solve this using charAt() first, and optionally anything else after.

        System.out.println(reverse(reversed));
    }

    public static String reverse(String toReverse) {
        String reversed = "";

        for (int i = toReverse.length()-1; i >= 0; i--) {
            reversed = reversed + toReverse.charAt(i);
        }
//        for(int i=0; i<toReverse.length(); i++){
//            reversed = toReverse.charAt(i)+reversed;
//        }
        return reversed;
    }
}