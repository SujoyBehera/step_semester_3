package week1.assigment_problems;

import java.util.Scanner;

public class MovieReviewWordLengthProfiler {
    static void classifyWordLengths(String review) {
        String trimmedReview = review.trim();
        if (trimmedReview.isEmpty()) {
            System.out.println("Short: 0 | Medium: 0 | Long: 0");
            return;
        }

        String[] words = trimmedReview.split("\\s+");
        int shortCount = 0, mediumCount = 0, longCount = 0;

        for (String word : words) {
            int length = word.length();
            if (length <= 4) shortCount++;
            else if (length <= 8) mediumCount++;
            else longCount++;
        }

        System.out.println("Short: " + shortCount + " | Medium: " + mediumCount + " | Long: " + longCount);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter movie review: ");
        String review = scanner.nextLine();
        classifyWordLengths(review);
    }
}
