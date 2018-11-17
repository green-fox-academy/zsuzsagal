import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WriteMultipleLines {
    public static void main(String[] args) {
        // Create a function that takes 3 parameters: a path, a word and a number,
        // than it should write to a file.
        // The path parameter should be a string, that describes the location of the file.
        // The word parameter should be a string, that will be written to the file as lines
        // The number parameter should describe how many lines the file should have.
        // So if the word is "apple" and the number is 5, than it should write 5 lines
        // to the file and each line should be "apple"
        // The function should not raise any error if it could not write the file.

        writeMultipleLines("my-file.txt", "apple", 5);
    }


    public static void writeMultipleLines(String fileName, String word, int number) {
        Path filePath = Paths.get(fileName);
        List<String> input = new ArrayList<>(Arrays.asList(word));
        try {
            for (int i = 0; i < number; i++) {
                Files.write(filePath, input);
                List<String> lines = Files.readAllLines(filePath);
                System.out.println(lines);
            }
        } catch (IOException e) {
            System.out.println("Could not find the file");
        }
    }
}



