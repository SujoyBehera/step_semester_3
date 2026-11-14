package week11.assigment_problems;

public class AttendanceDisorderScore {

    /**
     * Counts the number of disorder pairs (inversions) (i, j) such that i < j and roll[i] > roll[j]
     * using Merge Sort.
     *
     * Time Complexity: O(n log n) in all cases (best, average, and worst)
     * Extra Space Complexity: O(n) for the auxiliary merge buffer
     * Stable: Yes (when roll[i] <= roll[j], the left-half element is placed first, preserving relative order)
     */
    public static long countInversions(int[] roll) {
        if (roll == null || roll.length <= 1) {
            return 0L;
        }

        int[] copy = new int[roll.length];
        for (int i = 0; i < roll.length; i++) {
            copy[i] = roll[i];
        }
        int[] temp = new int[roll.length];

        return mergeSortAndCount(copy, temp, 0, copy.length - 1);
    }

    private static long mergeSortAndCount(int[] arr, int[] temp, int left, int right) {
        if (left >= right) {
            return 0L;
        }

        int mid = left + (right - left) / 2;
        long count = 0L;

        count += mergeSortAndCount(arr, temp, left, mid);
        count += mergeSortAndCount(arr, temp, mid + 1, right);
        count += mergeAndCount(arr, temp, left, mid, right);

        return count;
    }

    private static long mergeAndCount(int[] arr, int[] temp, int left, int mid, int right) {
        int i = left;
        int j = mid + 1;
        int k = left;
        long inversions = 0L;

        while (i <= mid && j <= right) {
            if (arr[i] <= arr[j]) {
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];
                inversions += (mid - i + 1);
            }
        }

        while (i <= mid) {
            temp[k++] = arr[i++];
        }

        while (j <= right) {
            temp[k++] = arr[j++];
        }

        for (int idx = left; idx <= right; idx++) {
            arr[idx] = temp[idx];
        }

        return inversions;
    }
}
