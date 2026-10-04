package week9.assigment_problems;

import java.util.ArrayList;
import java.util.List;

public class MergingTwoTokenQueues {

    /**
     * Combines two sorted token queues into a single sorted list using two pointers.
     * Preserves all duplicates.
     * Time Complexity: O(m + n) where m and n are the lengths of counterA and counterB.
     * Space Complexity: O(m + n) to store and return the merged result.
     */
    public static int[] mergeTokens(int[] counterA, int[] counterB) {
        if (counterA == null) counterA = new int[0];
        if (counterB == null) counterB = new int[0];

        int[] result = new int[counterA.length + counterB.length];
        int i = 0;
        int j = 0;
        int k = 0;

        while (i < counterA.length && j < counterB.length) {
            if (counterA[i] <= counterB[j]) {
                result[k++] = counterA[i++];
            } else {
                result[k++] = counterB[j++];
            }
        }

        while (i < counterA.length) {
            result[k++] = counterA[i++];
        }

        while (j < counterB.length) {
            result[k++] = counterB[j++];
        }

        return result;
    }

    public static List<Integer> mergeTokens(List<Integer> counterA, List<Integer> counterB) {
        if (counterA == null) counterA = new ArrayList<>();
        if (counterB == null) counterB = new ArrayList<>();

        List<Integer> result = new ArrayList<>(counterA.size() + counterB.size());
        int i = 0;
        int j = 0;

        while (i < counterA.size() && j < counterB.size()) {
            if (counterA.get(i) <= counterB.get(j)) {
                result.add(counterA.get(i++));
            } else {
                result.add(counterB.get(j++));
            }
        }

        while (i < counterA.size()) {
            result.add(counterA.get(i++));
        }

        while (j < counterB.size()) {
            result.add(counterB.get(j++));
        }

        return result;
    }
}
