package week2.assigment_problems;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class StopWordFilteredWordFrequencyReport {
    static void printFilteredWordFrequency(String feedback) {
        String cleaned = feedback.toLowerCase().replace(".", "").replace(",", "");
        String[] words = cleaned.split("\\s+");
        String[] stopWords = {"the", "was", "and", "a", "is", "of", "in"};
        Map<String, Integer> frequency = new HashMap<>();

        for (String word : words) {
            boolean stop = false;
            for (String stopWord : stopWords) {
                if (word.equals(stopWord)) {
                    stop = true;
                    break;
                }
            }
            if (!stop && !word.isEmpty()) {
                Integer count = frequency.get(word);
                frequency.put(word, count == null ? 1 : count + 1);
            }
        }

        List<Map.Entry<String, Integer>> entries = new ArrayList<>(frequency.entrySet());
        entries.sort(Map.Entry.comparingByValue(Comparator.reverseOrder()));
        for (Map.Entry<String, Integer> entry : entries) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter feedback paragraph: ");
        printFilteredWordFrequency(scanner.nextLine());
    }
}
