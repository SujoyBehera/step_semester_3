package week9.class_problems;

import java.util.HashSet;
import java.util.Set;

public class PairWithTargetSum {

    /**
     * Determines if any two distinct elements in nums sum up to target.
     * Optimal Hash-Set approach:
     * Time Complexity: O(n) average time where n is the length of nums.
     * Space Complexity: O(n) auxiliary space to store seen complements.
     */
    public static boolean hasPairWithSum(int[] nums, int target) {
        if (nums == null || nums.length < 2) {
            return false;
        }

        Set<Integer> seen = new HashSet<>();
        for (int num : nums) {
            int complement = target - num;
            if (seen.contains(complement)) {
                return true;
            }
            seen.add(num);
        }

        return false;
    }

    /**
     * Brute-force approach: checks all pairs of distinct indices.
     * Time Complexity: O(n^2) where n is the length of nums.
     * Space Complexity: O(1) auxiliary space.
     */
    public static boolean hasPairWithSumBruteForce(int[] nums, int target) {
        if (nums == null || nums.length < 2) {
            return false;
        }

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return true;
                }
            }
        }

        return false;
    }
}
