import java.util.Arrays;

public class Bubble {
    public static void main(String[] args) {
        //  Create a function that takes a list of numbers as parameter
        //  Returns a list where the elements are sorted in ascending numerical order
        //  Make a second boolean parameter, if it's `true` sort that list descending

        //  Example:
        //  System.out.println(bubble(new int[] {34, 12, 24, 9, 5}));
        //  should print [5, 9, 12, 24, 34]
        //  System.out.println(advancedBubble(new int[] {34, 12, 24, 9, 5}, true));
        //  should print [34, 24, 12, 9, 5]

        int[] arrayToRun = {34, 12, 24, 9, 5};

        bubble(arrayToRun);
        for (int i = 0; i < arrayToRun.length; i++) {
            System.out.println(arrayToRun[i]);
        }

        System.out.println();

        advancedBubble(arrayToRun, true);
        for (int i = 0; i < arrayToRun.length; i++) {
            System.out.println(arrayToRun[i]);
        }
    }


    public static int[] bubble(int[] numbers) {

        int tempValue;

        for (int i = 0; i < numbers.length - 1; i++) {
            for (int j = 0; j < (numbers.length - 1 - i); j++) {

                if (numbers[j] > numbers[j + 1]) {
                    tempValue = numbers[j];
                    numbers[j] = numbers[j + 1];
                    numbers[j + 1] = tempValue;
                }
            }
        }
        return numbers;
    }


    public static int[] advancedBubble(int[] numbers, boolean isTrue) {

        int tempValue;
        if (!isTrue) {
            numbers = bubble(numbers);
        }
        else {
            for (int i = 0; i < numbers.length - 1; i++) {
                for (int j = 0; j < (numbers.length - 1 - i); j++) {
                    if (isTrue==true) {
                        if (numbers[j] < numbers[j + 1]) {
                            tempValue = numbers[j];
                            numbers[j] = numbers[j + 1];
                            numbers[j + 1] = tempValue;
                        }
                    }
                }
            }
        }
        return numbers;

    }

}