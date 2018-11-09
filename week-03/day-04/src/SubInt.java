import java.util.ArrayList;

public class SubInt {
    public static void main(String[] args) {
        //  Create a function that takes a number and a list of numbers as a parameter
        //  Returns the indexes of the numbers in the list where the first number is part of
        //  Returns an empty list if the number is not part any of the numbers in the list

        //  Example:
        //System.out.println(subInt(1, new int[] {1, 11, 34, 52, 61}));
        //  should print: `[0, 1, 4]`
        // System.out.println(subInt(9, new int[] {1, 11, 34, 52, 61}));
        //  should print: '[]'

        int[] input = {1, 11, 34, 52, 61};
        System.out.println(isInList(1, input));
    }

    public static ArrayList<Integer> isInList(int number, int[] inputList) {

        ArrayList<String> inputAsArray = new ArrayList<>();
        for (int i : inputList) {
            inputAsArray.add(String.valueOf(i));
        }

        String valueOfNumber = String.valueOf(number);

        ArrayList<Integer> listOfIndexes = new ArrayList<>();

        for (int i = 0; i < inputAsArray.size(); i++) {
            if (inputAsArray.get(i).contains(valueOfNumber)) {
                listOfIndexes.add(i);
            }
        }
        return listOfIndexes;
    }
}

