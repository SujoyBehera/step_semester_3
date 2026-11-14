package week11.assigment_problems;

public class NoticeBoardShuffle {

    /**
     * Sorts the test scores array in ascending order using Bubble Sort (neighbour-swap method)
     * with early termination and returns {passes, swaps}.
     *
     * Why an already-sorted board needs only one pass:
     * During the first full sweep from left to right, every adjacent pair satisfies
     * scores[j] <= scores[j + 1], so no swap occurs and the 'swapped' flag remains false.
     * Because zero swaps occurred across the entire sweep, every element is confirmed to be
     * <= its right neighbour (and transitively <= all elements to its right), allowing the
     * algorithm to terminate immediately after Pass 1 in O(n) time.
     *
     * Time Complexity: O(n^2) worst and average case, O(n) best case (already sorted)
     * Extra Space Complexity: O(1)
     * Stable: Yes (only swaps when scores[j] > scores[j + 1], preserving relative order of equal scores)
     */
    public static int[] bubbleStats(int[] scores) {
        if (scores == null || scores.length <= 1) {
            return new int[]{0, 0};
        }

        int n = scores.length;
        int passes = 0;
        int swaps = 0;

        for (int i = 0; i < n - 1; i++) {
            passes++;
            boolean swapped = false;

            for (int j = 0; j < n - 1 - i; j++) {
                if (scores[j] > scores[j + 1]) {
                    int temp = scores[j];
                    scores[j] = scores[j + 1];
                    scores[j + 1] = temp;
                    swaps++;
                    swapped = true;
                }
            }

            if (!swapped) {
                break;
            }
        }

        return new int[]{passes, swaps};
    }
}
