package week9.assigment_problems;

import java.util.List;

public class ClassTopperFinder {

    public static class TopperResult {
        private final int rowIndex;
        private final int total;

        public TopperResult(int rowIndex, int total) {
            this.rowIndex = rowIndex;
            this.total = total;
        }

        public int getRowIndex() {
            return rowIndex;
        }

        public int getTotal() {
            return total;
        }

        @Override
        public String toString() {
            return "(" + rowIndex + ", " + total + ")";
        }
    }

    /**
     * Finds the student with highest total marks across subjects.
     * If two or more students have the same highest total, the one with the smallest row index is returned.
     * Time Complexity: O(m * n) where m is number of students and n is number of subjects.
     * Space Complexity: O(1) auxiliary space beyond the input grid.
     */
    public static TopperResult findTopper(int[][] marks) {
        if (marks == null || marks.length == 0) {
            return new TopperResult(0, 0);
        }

        int bestIndex = 0;
        int maxTotal = Integer.MIN_VALUE;

        for (int r = 0; r < marks.length; r++) {
            int currentTotal = 0;
            for (int c = 0; c < marks[r].length; c++) {
                currentTotal += marks[r][c];
            }
            if (currentTotal > maxTotal) {
                maxTotal = currentTotal;
                bestIndex = r;
            }
        }

        return new TopperResult(bestIndex, maxTotal);
    }

    public static TopperResult findTopper(List<List<Integer>> marks) {
        if (marks == null || marks.isEmpty()) {
            return new TopperResult(0, 0);
        }

        int bestIndex = 0;
        int maxTotal = Integer.MIN_VALUE;

        for (int r = 0; r < marks.size(); r++) {
            List<Integer> studentMarks = marks.get(r);
            int currentTotal = 0;
            for (int mark : studentMarks) {
                currentTotal += mark;
            }
            if (currentTotal > maxTotal) {
                maxTotal = currentTotal;
                bestIndex = r;
            }
        }

        return new TopperResult(bestIndex, maxTotal);
    }
}
