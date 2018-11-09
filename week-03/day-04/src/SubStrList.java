import java.util.ArrayList;

public class SubStrList {
    public static void main(String[] args) {
        //  Create a function that takes a string and a list of string as a parameter
        //  Returns the index of the string in the list where the first string is part of
        //  Only need to find the first occurrence and return the index of that
        //  Returns `-1` if the string is not part any of the strings in the list

        //  Example
        // String[] searchArr = new String[] {"this", "is", "what", "I'm", "searching"};
        // System.out.println(subStrList("ching", searchArr));
        //  should print: `4`
        // System.out.println(subStrList("not", searchArr));
        //  should print: `-1`

        String[] input = {"this", "is", "what", "I'm", "searching"};
        System.out.println(isInSubstrList("ching", input));
    }


    public static int isInSubstrList(String subString, String[] inputList) {
        for (int i = 0; i < inputList.length; i++) {
            if (inputList[i].contains(subString)) {
                return i;
            }
        }
        return -1;
    }
}


// this solution handles multiple indexes :

//    public static ArrayList<Integer> isInSubstrList(String subString, String[] inputList) {
//        ArrayList<Integer> listOfIndexes = new ArrayList<>();
//        for (int i = 0; i < inputList.length; i++) {
//            if (inputList[i].contains(subString)) {
//                listOfIndexes.add(i);
//                return listOfIndexes;
//            }
//        }
//        return null;
//    }
//}