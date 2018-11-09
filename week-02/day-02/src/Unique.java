import java.util.Arrays;

public class Unique {
    public static void main(String[] args) {
        //  Create a function that takes a list of numbers as a parameter
        //  Returns a list of numbers where every number in the list occurs only once

        //  Example
        // System.out.println(unique(new int[] {1, 11, 34, 11, 52, 61, 1, 34}));
        //  should print: `[1, 11, 34, 52, 61]`

        int[] numbers = {1, 11, 34, 11, 52, 61, 1, 34};
        unique(numbers);
    }


    public static int[] unique(int[] numbers) {
        int[] unique = new int[numbers.length];
        int indexInUnique = 0; // = length of unique array


        for (int i = 0; i < numbers.length; i++) {
            boolean isInUnique = false;
            for (int j = 0; j < indexInUnique; j++) {
                if (numbers[i] == unique[j]) {
                    isInUnique = true;
                }
            }

            if (!isInUnique) {
                unique[indexInUnique] = numbers[i];
                indexInUnique++;
            }
        }

        for (int i = 0; i < indexInUnique; i++) {
            System.out.println(unique[i]);
        }
        return unique;
    }
}


