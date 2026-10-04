package week9.assigment_problems;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MostPopularCanteenOrder {

    public static class PopularItemResult {
        private final String item;
        private final int count;

        public PopularItemResult(String item, int count) {
            this.item = item;
            this.count = count;
        }

        public String getItem() {
            return item;
        }

        public int getCount() {
            return count;
        }

        @Override
        public String toString() {
            return "(\"" + item + "\", " + count + ")";
        }
    }

    /**
     * Finds the most frequently ordered item.
     * Ties are broken by returning the item that appears first in the orders list.
     * Time Complexity: O(n) where n is the number of orders.
     * Space Complexity: O(u) where u is the number of unique items ordered.
     */
    public static PopularItemResult mostPopular(String[] orders) {
        if (orders == null || orders.length == 0) {
            return new PopularItemResult("", 0);
        }

        Map<String, Integer> counts = new HashMap<>();
        int maxCount = 0;

        for (String order : orders) {
            int newCount = counts.getOrDefault(order, 0) + 1;
            counts.put(order, newCount);
            if (newCount > maxCount) {
                maxCount = newCount;
            }
        }

        // Second pass in original order to break ties by first occurrence
        for (String order : orders) {
            if (counts.get(order) == maxCount) {
                return new PopularItemResult(order, maxCount);
            }
        }

        return new PopularItemResult("", 0);
    }

    public static PopularItemResult mostPopular(List<String> orders) {
        if (orders == null || orders.isEmpty()) {
            return new PopularItemResult("", 0);
        }

        Map<String, Integer> counts = new HashMap<>();
        int maxCount = 0;

        for (String order : orders) {
            int newCount = counts.getOrDefault(order, 0) + 1;
            counts.put(order, newCount);
            if (newCount > maxCount) {
                maxCount = newCount;
            }
        }

        for (String order : orders) {
            if (counts.get(order) == maxCount) {
                return new PopularItemResult(order, maxCount);
            }
        }

        return new PopularItemResult("", 0);
    }
}
