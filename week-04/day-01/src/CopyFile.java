import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class CopyFile {
    public static void main(String[] args) {
        // Write a function that copies a file to another
        // It should take the file names as parameters
        // It should return a boolean that shows if the copy was successful

        System.out.println(isCopied("my-file.txt", "another-file.txt"));
    }

    public static boolean isCopied(String fileSource, String fileDest) {
        boolean isCopied = true;
        try {
            Files.copy(Paths.get(fileSource), Paths.get(fileDest));
        } catch (IOException e) {
            isCopied = false;
        }
        return isCopied;
    }
}

