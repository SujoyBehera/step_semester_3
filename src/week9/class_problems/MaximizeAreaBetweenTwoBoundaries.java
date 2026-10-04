package week9.class_problems;

public class MaximizeAreaBetweenTwoBoundaries {

    /**
     * Finds the maximum area of water that can be contained between two vertical lines.
     * Uses Two-Pointer technique moving inward from the boundaries.
     * Area formula: min(heights[i], heights[j]) * (j - i).
     * Time Complexity: O(n) where n is the number of elements in heights.
     * Space Complexity: O(1) auxiliary space.
     */
    public static int maxContainerArea(int[] heights) {
        if (heights == null || heights.length < 2) {
            return 0;
        }

        int left = 0;
        int right = heights.length - 1;
        int maxArea = 0;

        while (left < right) {
            int width = right - left;
            int h = Math.min(heights[left], heights[right]);
            int currentArea = width * h;

            if (currentArea > maxArea) {
                maxArea = currentArea;
            }

            if (heights[left] < heights[right]) {
                left++;
            } else {
                right--;
            }
        }

        return maxArea;
    }

    /**
     * Brute force method checking every pair of boundaries.
     * Time Complexity: O(n^2).
     * Space Complexity: O(1).
     */
    public static int maxContainerAreaBruteForce(int[] heights) {
        if (heights == null || heights.length < 2) {
            return 0;
        }

        int maxArea = 0;
        for (int i = 0; i < heights.length; i++) {
            for (int j = i + 1; j < heights.length; j++) {
                int area = Math.min(heights[i], heights[j]) * (j - i);
                if (area > maxArea) {
                    maxArea = area;
                }
            }
        }

        return maxArea;
    }
}
