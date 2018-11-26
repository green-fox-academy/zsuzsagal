package extension;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Extension {

    int add(int a, int b) {
        return a + b;
    }

    int maxOfThree(int a, int b, int c) {
        if ((a > b) && (a > c))
            return a;
        else if ((b > c) && (b > a))
            return b;
        else return c;
    }


    int median(List<Integer> pool) {
        Collections.sort(pool);
        return pool.get((pool.size() - 1) / 2);
    }


    boolean isVowel(char c) {
        return Arrays.asList('a', 'u', 'o', 'e', 'i').contains(c);
    }

    String translate(String hungarian) {
        String teve = hungarian;
        int length = teve.length();
        for (int i = 0; i < length; i++) {
            char c = teve.charAt(i);
            if (isVowel(c)) {
//              teve = String.join(c + "v" + c, teve.split(""+c));
                teve = teve.substring(0, i + 1) + "v" + c + teve.substring(i + 1);
                i += 2;
                length += 2;
            }
        }
        return teve;
    }
}


