import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WriteSingleLine {
    public static void main(String[] args) {
        // Open a file called "my-file.txt"
        // Write your name in it as a single line
        // If the program is unable to write the file,
        // then it should print an error message like: "Unable to write file: my-file.txt"

        writeSingleLine();
    }


    public static void writeSingleLine() {
        Path filePath = Paths.get("my-file.txt");
        List<String> input = new ArrayList<>(Arrays.asList("Zsuzsa Gal"));
        try {
            Files.write(filePath, input);
            List<String> lines = Files.readAllLines(filePath);
            System.out.println(lines);
        } catch (IOException e) {
            System.out.println("Unable to write file: my-file.txt");
        }
    }
}


