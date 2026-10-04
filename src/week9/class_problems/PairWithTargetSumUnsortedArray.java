package week9.class_problems;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class PairWithTargetSumUnsortedArray {

    /**
     * Determines whether any two distinct elements in nums sum up to target.
     * Uses a Hash Set for single-pass lookup.
     * Time Complexity: O(n) average time.
     * Space Complexity: O(n) auxiliary space.
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
     * Sorting and Two-Pointer approach.
     * Time Complexity: O(n log n) due to sorting.
     * Space Complexity: O(n) or O(log n) depending on sort implementation.
     */
    public static boolean hasPairWithSumTwoPointers(int[] nums, int target) {
        if (nums == null || nums.length < 2) {
            return false;
        }

        int[] copy = Arrays.copyOf(nums, nums.length);
        Arrays.sort(copy);

        int left = 0;
        int right = copy.length - 1;

        while (left < right) {
            int sum = copy[left] + copy[right];
            if (sum == target) {
                return true;
            } else if (sum < target) {
                left++;
            } else {
                right--;
            }
        }

        return false;
    }

    /**
     * Brute force comparison checking all possible pairs.
     * Time Complexity: O(n^2).
     * Space Complexity: O(1).
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
