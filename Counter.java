import java.io.*;
import java.util.*;

public class Counter {

    public static void main(String[] args) {
        
        String inputPath = "input.txt";
        String outputPath = "output.txt";

        // TreeMap 
        Map<String, Integer> wordCounts = new TreeMap<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(inputPath))) {
            String line;

            while ((line = reader.readLine()) != null) {
                String word = line.trim().toLowerCase();  // Make word case-insensitive
                if (!word.isEmpty()) {
                    wordCounts.put(word, wordCounts.getOrDefault(word, 0) + 1);
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading input file: " + e.getMessage());
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputPath))) {
            // Write each word and its count to the output file
            for (Map.Entry<String, Integer> entry : wordCounts.entrySet()) {
                writer.write(entry.getKey() + " " + entry.getValue());
                writer.newLine();
            }
            System.out.println("Word count is: " + outputPath);
        } catch (IOException e) {
            System.out.println("Error writing to output file: " + e.getMessage());
        }
    }
}
