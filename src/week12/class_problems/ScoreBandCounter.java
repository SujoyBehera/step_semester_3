package week12.class_problems;

public class ScoreBandCounter {

    /**
     * Returns the first index in the sorted scores array whose value is at least x.
     * If all elements are strictly less than x, returns scores.length.
     *
     * Time Complexity per query: O(log n) using binary search, compared to O(n) for a linear scan.
     * Space Complexity: O(1) auxiliary space.
     */
    public static int lowerBound(int[] scores, int x) {
        if (scores == null || scores.length == 0) {
            return 0;
        }

        int low = 0;
        int high = scores.length;

        while (low < high) {
            int mid = low + (high - low) / 2;
            if (scores[mid] >= x) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }

        return low;
    }

    /**
     * Reports how many students scored exactly x and how many scored below x
     * using two lowerBound binary searches.
     *
     * Time Complexity: O(log n) per query vs. O(n) for a linear scan.
     */
    public static String query(int[] scores, int x) {
        int below = lowerBound(scores, x);
        int exactly = lowerBound(scores, x + 1) - below;
        return x + ": exactly " + exactly + ", below " + below;
    }
}
