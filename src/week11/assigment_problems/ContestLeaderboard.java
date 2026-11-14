package week11.assigment_problems;

public class ContestLeaderboard {

    public static class Entry {
        public String name;
        public int marks;

        public Entry(String name, int marks) {
            this.name = name;
            this.marks = marks;
        }

        public String getName() {
            return name;
        }

        public int getMarks() {
            return marks;
        }

        @Override
        public String toString() {
            return name + " " + marks;
        }
    }

    /**
     * Orders contest entries from highest marks to lowest (0..100) using Counting Sort
     * with key = 100 - marks, preserving submission order for students with equal marks.
     *
     * Time Complexity: O(n + 101)
     * Extra Space Complexity: O(n + 101) for the output array and count array of size 101
     * Stable: Yes (cumulative counts combined with right-to-left traversal preserve input order for ties)
     */
    public static Entry[] leaderboard(Entry[] entries) {
        if (entries == null) {
            return new Entry[0];
        }
        int n = entries.length;
        if (n == 0) {
            return new Entry[0];
        }

        int[] count = new int[101];
        for (int i = 0; i < n; i++) {
            int key = 100 - entries[i].marks;
            count[key]++;
        }

        for (int k = 1; k < 101; k++) {
            count[k] += count[k - 1];
        }

        Entry[] output = new Entry[n];
        for (int i = n - 1; i >= 0; i--) {
            int key = 100 - entries[i].marks;
            count[key]--;
            output[count[key]] = entries[i];
        }

        return output;
    }
}
