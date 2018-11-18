import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class Logs {
    public static void main(String[] args) {
        // Read all data from 'log.txt'.
        // Each line represents a log message from a web server
        // Write a function that returns an array with the unique IP addresses.
        // Write a function that returns the GET / POST request ratio.

        System.out.println(getUniqueIp());
        System.out.println(requestRatio());
    }


    public static String[] getUniqueIp() {
        Path filePath = Paths.get("log.txt");
        Set<String> setOfIps = new HashSet<>();
        String[] uniqueIps = new String[setOfIps.size()];

        try {
            List<String> lines = Files.readAllLines(filePath);
            for (int i = 0; i < lines.size(); i++) {
                setOfIps.add(lines.get(i).substring(27, 38));
            }
            uniqueIps = setOfIps.toArray(uniqueIps);
            System.out.println(Arrays.toString(uniqueIps));
        } catch (IOException e) {
            System.out.println("file not found");
        }
       return uniqueIps;
    }


    public static double requestRatio() {
        int countGet = 0;
        int countPost = 0;
        Path filePath = Paths.get("log.txt");

        try {
            List<String> lines = Files.readAllLines(filePath);
            for (int i = 0; i < lines.size(); i++) {
                if (lines.get(i).contains("GET")) {
                    countGet++;
                }
                if (lines.get(i).contains("POST")) {
                    countPost++;
                }
            }
        } catch (
                IOException e) {
            System.out.println("file not found");
        }
        return (double) countGet / countPost;
    }
}










