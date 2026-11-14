package week11.assigment_problems;

public class PlacementCutoff {

    /**
     * Finds and returns the k-th highest mark (1 <= k <= marks.length) using Quickselect
     * with Lomuto partitioning (last element as pivot). Duplicate marks count separately.
     *
     * Time Complexity: O(n) average case, O(n^2) worst case
     * Extra Space Complexity: O(1) auxiliary space (iterative partitioning on in-place array)
     * Stable: No (partitioning swaps non-adjacent elements across the array, altering relative order of equals)
     */
    public static int kthHighest(int[] marks, int k) {
        if (marks == null || marks.length == 0 || k < 1 || k > marks.length) {
            throw new IllegalArgumentException("Invalid marks array or k out of bounds.");
        }

        int n = marks.length;
        int targetIndex = n - k;
        int low = 0;
        int high = n - 1;

        while (low <= high) {
            int pivotIndex = partition(marks, low, high);
            if (pivotIndex == targetIndex) {
                return marks[pivotIndex];
            } else if (pivotIndex < targetIndex) {
                low = pivotIndex + 1;
            } else {
                high = pivotIndex - 1;
            }
        }

        return marks[targetIndex];
    }

    private static int partition(int[] marks, int low, int high) {
        int pivot = marks[high];
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (marks[j] <= pivot) {
                i++;
                int temp = marks[i];
                marks[i] = marks[j];
                marks[j] = temp;
            }
        }

        int temp = marks[i + 1];
        marks[i + 1] = marks[high];
        marks[high] = temp;

        return i + 1;
    }
}
