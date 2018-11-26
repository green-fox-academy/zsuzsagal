package sum;

import java.util.ArrayList;
import java.util.Arrays;

public class Sum {
//    Create a sum method in your class which has an ArrayList of Integers as parameter
//    It should return the sum of the elements in the list

    public int sumOfArray(ArrayList<Integer> numbers) {
        int sumOfElements = 0;
        if (!(numbers instanceof ArrayList)) {
            return 0;
        }
        for (Integer ints : numbers) {
            sumOfElements += ints;
        }
        System.out.println(sumOfElements);
        return sumOfElements;
    }


    public static void main(String[] args) {
        ArrayList<Integer> numbers = new ArrayList<Integer>(Arrays.asList());
        Sum sum1 = new Sum();
        sum1.sumOfArray(numbers);
    }
}
