package week9.assigment_problems;

import java.util.List;

public class HotWeatherAlertWindows {

    /**
     * Counts the number of k-hour blocks whose average temperature >= threshold.
     * Uses a Sliding Window technique.
     * Compares sum >= k * threshold to avoid decimal precision issues.
     * Time Complexity: O(n) where n is the number of temperature readings.
     * Space Complexity: O(1) auxiliary space.
     */
    public static int countAlerts(int[] readings, int k, int threshold) {
        if (readings == null || k <= 0 || readings.length < k) {
            return 0;
        }

        long targetSum = (long) k * threshold;
        long currentSum = 0;

        for (int i = 0; i < k; i++) {
            currentSum += readings[i];
        }

        int count = 0;
        if (currentSum >= targetSum) {
            count++;
        }

        for (int i = k; i < readings.length; i++) {
            currentSum += readings[i] - readings[i - k];
            if (currentSum >= targetSum) {
                count++;
            }
        }

        return count;
    }

    public static int countAlerts(List<Integer> readings, int k, int threshold) {
        if (readings == null || k <= 0 || readings.size() < k) {
            return 0;
        }

        long targetSum = (long) k * threshold;
        long currentSum = 0;

        for (int i = 0; i < k; i++) {
            currentSum += readings.get(i);
        }

        int count = 0;
        if (currentSum >= targetSum) {
            count++;
        }

        for (int i = k; i < readings.size(); i++) {
            currentSum += readings.get(i) - readings.get(i - k);
            if (currentSum >= targetSum) {
                count++;
            }
        }

        return count;
    }
}
