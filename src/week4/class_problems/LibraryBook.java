package week4.class_problems;

public class LibraryBook {
    private String title;
    private String isbn;

    public LibraryBook(String title, String isbn) {
        this.title = title;
        this.isbn = (isbn == null || isbn.isBlank()) ? "PENDING" : isbn;
    }

    public LibraryBook(String title) {
        this(title, "PENDING");
    }

    public boolean isCatalogued() {
        return isbn != null && !isbn.isBlank();
    }

    public void printStatus() {
        System.out.println(title + " | " + isbn + " | Catalogued: " + isCatalogued());
    }

    public static void main(String[] args) {
        String[] titles = {"Clean Code", "Untitled Draft", "1984", "Notes"};
        String[] isbns = {"978-0132350884", "", "9780451524935", ""};

        for (int i = 0; i < titles.length; i++) {
            LibraryBook book = isbns[i].isBlank()
                    ? new LibraryBook(titles[i])
                    : new LibraryBook(titles[i], isbns[i]);
            book.printStatus();
        }
    }
}
