import java.io.BufferedReader;

import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;


public class Main {
    public static void main(String[] args) {
        String filename = "E:\\Exam\\example.txt";


        Map<String, Integer> wordCounts = new TreeMap<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {

                String[] words = line.split("\\s+");


                for (String word : words) {

                    word = word.replaceAll("[^a-zA-Z]", "").toLowerCase();


                    if (!word.isEmpty()) {
                        wordCounts.put(word, wordCounts.getOrDefault(word, 0) + 1);
                    }
                }
            }
        } catch (IOException e) {
            System.err.println("Error reading the file: " + e.getMessage());
            return;
        }


        for (Map.Entry<String, Integer> entry : wordCounts.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}