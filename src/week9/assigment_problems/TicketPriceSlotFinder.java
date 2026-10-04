package week9.assigment_problems;

import java.util.List;

public class TicketPriceSlotFinder {

    /**
     * Finds the index where newPrice exists or where it should be inserted to keep prices sorted.
     * Uses Binary Search.
     * Time Complexity: O(log n) where n is the length of prices.
     * Space Complexity: O(1) auxiliary space.
     */
    public static int findSlot(int[] prices, int newPrice) {
        if (prices == null || prices.length == 0) {
            return 0;
        }

        int low = 0;
        int high = prices.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (prices[mid] == newPrice) {
                return mid;
            } else if (prices[mid] < newPrice) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return low;
    }

    public static int findSlot(List<Integer> prices, int newPrice) {
        if (prices == null || prices.isEmpty()) {
            return 0;
        }

        int low = 0;
        int high = prices.size() - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            int midVal = prices.get(mid);
            if (midVal == newPrice) {
                return mid;
            } else if (midVal < newPrice) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return low;
    }
}
