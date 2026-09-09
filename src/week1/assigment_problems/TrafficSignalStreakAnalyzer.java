package week1.assigment_problems;

import java.util.Scanner;

public class TrafficSignalStreakAnalyzer {
    static void findLongestStreak(String signalLog) {
        if (signalLog.isEmpty()) {
            System.out.println("No Signal Readings Found");
            return;
        }

        char longestColor = signalLog.charAt(0);
        int longestLength = 1;
        int currentLength = 1;

        for (int i = 1; i < signalLog.length(); i++) {
            if (signalLog.charAt(i) == signalLog.charAt(i - 1)) {
                currentLength++;
            } else {
                currentLength = 1;
            }

            if (currentLength > longestLength) {
                longestLength = currentLength;
                longestColor = signalLog.charAt(i);
            }
        }

        System.out.println("Longest Streak: '" + longestColor + "' repeated " + longestLength + " times");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter signal log: ");
        String signalLog = scanner.nextLine().trim().toUpperCase();
        findLongestStreak(signalLog);
    }
}
