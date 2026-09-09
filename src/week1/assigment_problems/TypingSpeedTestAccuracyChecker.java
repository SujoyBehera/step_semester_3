package week1.assigment_problems;

import java.util.Scanner;

public class TypingSpeedTestAccuracyChecker {
    static void checkTypingAccuracy(String original, String typed) {
        int total = Math.min(original.length(), typed.length());
        int matched = 0;
        int firstMismatch = -1;

        for (int i = 0; i < total; i++) {
            if (original.charAt(i) == typed.charAt(i)) matched++;
            else if (firstMismatch == -1) firstMismatch = i;
        }

        int lengthDifference = Math.abs(original.length() - typed.length());
        matched = Math.min(matched, total);
        int comparedLength = Math.max(original.length(), typed.length());
        double accuracy = comparedLength == 0 ? 100.0 : matched * 100.0 / comparedLength;

        if (firstMismatch == -1 && original.length() != typed.length()) {
            firstMismatch = total;
        }

        System.out.printf("Matched: %d/%d | Accuracy: %.2f%%", matched, comparedLength, accuracy);
        if (firstMismatch == -1) {
            System.out.println(" | No Mismatches");
        } else {
            char originalChar = firstMismatch < original.length() ? original.charAt(firstMismatch) : '-';
            char typedChar = firstMismatch < typed.length() ? typed.charAt(firstMismatch) : '-';
            System.out.println(" | First Mismatch at position " + (firstMismatch + 1)
                    + " ('" + originalChar + "' vs '" + typedChar + "')");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter original passage: ");
        String original = scanner.nextLine();
        System.out.print("Enter typed text: ");
        String typed = scanner.nextLine();
        checkTypingAccuracy(original, typed);
    }
}
