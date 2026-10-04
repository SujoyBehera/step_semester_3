package week9.class_problems;

import java.util.List;

public class LibraryCatalogLookup {

    public static class BookRecord {
        private final String isbn;
        private final String title;

        public BookRecord(String isbn, String title) {
            if (isbn == null || isbn.trim().isEmpty()) {
                throw new IllegalArgumentException("ISBN cannot be blank");
            }
            if (title == null || title.trim().isEmpty()) {
                throw new IllegalArgumentException("Title cannot be blank");
            }
            this.isbn = isbn;
            this.title = title;
        }

        public String getIsbn() {
            return isbn;
        }

        public String getTitle() {
            return title;
        }

        @Override
        public String toString() {
            return "(\"" + isbn + "\", \"" + title + "\")";
        }
    }

    /**
     * Binary search to find a book title by target ISBN in a sorted catalog.
     * Time Complexity: O(log n) where n is the number of books in the catalog.
     * Space Complexity: O(1) auxiliary space.
     */
    public static String findBook(List<BookRecord> catalog, String targetIsbn) {
        if (catalog == null || targetIsbn == null) {
            return "Not Found";
        }

        int low = 0;
        int high = catalog.size() - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            BookRecord midBook = catalog.get(mid);
            int cmp = midBook.getIsbn().compareTo(targetIsbn);

            if (cmp == 0) {
                return midBook.getTitle();
            } else if (cmp < 0) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return "Not Found";
    }

    public static String findBook(String[][] catalog, String targetIsbn) {
        if (catalog == null || targetIsbn == null) {
            return "Not Found";
        }

        int low = 0;
        int high = catalog.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            String midIsbn = catalog[mid][0];
            int cmp = midIsbn.compareTo(targetIsbn);

            if (cmp == 0) {
                return catalog[mid][1];
            } else if (cmp < 0) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return "Not Found";
    }
}
