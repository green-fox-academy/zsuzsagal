import java.util.*;

public class AppendLetter {
    public static void main(String... args) {

//      Create a method called "appendA()" that adds "a" to every string in the "far" list.
//      The parameter should be a list.
//      The output should be: "boa", "anaconda", "koala", "panda", "zebra"

        List<String> far = Arrays.asList("bo", "anacond", "koal", "pand", "zebr");
        System.out.println(appendA(far));
    }


    public static ArrayList<String> appendA(List input) {

        String charToAppend = "a";
        ArrayList<String> output = new ArrayList<>();
        String addedCharA = "";

        for (int i = 0; i < input.size(); i++) {

            addedCharA = input.get(i) + charToAppend;
            output.add(addedCharA);
        }
        return output;
    }
}

