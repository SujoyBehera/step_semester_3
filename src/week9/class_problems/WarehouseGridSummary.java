package week9.class_problems;

import java.util.List;

public class WarehouseGridSummary {

    public static class Coordinate {
        private final int row;
        private final int col;

        public Coordinate(int row, int col) {
            this.row = row;
            this.col = col;
        }

        public int getRow() {
            return row;
        }

        public int getCol() {
            return col;
        }

        @Override
        public String toString() {
            return "(" + row + ", " + col + ")";
        }
    }

    public static class SummaryResult {
        private final int totalItems;
        private final Coordinate maxCoordinate;

        public SummaryResult(int totalItems, Coordinate maxCoordinate) {
            this.totalItems = totalItems;
            this.maxCoordinate = maxCoordinate;
        }

        public int getTotalItems() {
            return totalItems;
        }

        public Coordinate getMaxCoordinate() {
            return maxCoordinate;
        }

        @Override
        public String toString() {
            return "(" + totalItems + ", " + maxCoordinate + ")";
        }
    }

    /**
     * Calculates total items across all bins and finds the coordinates of the bin with max items.
     * Ties are broken by picking the first encountered row by row from left to right.
     * Time Complexity: O(m * n) where m is number of rows and n is number of columns.
     * Space Complexity: O(1) auxiliary space beyond the input grid.
     */
    public static SummaryResult warehouseSummary(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return new SummaryResult(0, new Coordinate(0, 0));
        }

        int total = 0;
        int maxVal = Integer.MIN_VALUE;
        int maxRow = 0;
        int maxCol = 0;

        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[r].length; c++) {
                int val = grid[r][c];
                total += val;
                if (val > maxVal) {
                    maxVal = val;
                    maxRow = r;
                    maxCol = c;
                }
            }
        }

        return new SummaryResult(total, new Coordinate(maxRow, maxCol));
    }

    public static SummaryResult warehouseSummary(List<List<Integer>> grid) {
        if (grid == null || grid.isEmpty() || grid.get(0).isEmpty()) {
            return new SummaryResult(0, new Coordinate(0, 0));
        }

        int total = 0;
        int maxVal = Integer.MIN_VALUE;
        int maxRow = 0;
        int maxCol = 0;

        for (int r = 0; r < grid.size(); r++) {
            List<Integer> rowList = grid.get(r);
            for (int c = 0; c < rowList.size(); c++) {
                int val = rowList.get(c);
                total += val;
                if (val > maxVal) {
                    maxVal = val;
                    maxRow = r;
                    maxCol = c;
                }
            }
        }

        return new SummaryResult(total, new Coordinate(maxRow, maxCol));
    }
}
