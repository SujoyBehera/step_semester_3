package session_1.class_problems;

public class M4ReferenceCopiesandSharedIDCard {
    static class IdCard {
        String name;
        int booksIssued;

        IdCard(String name, int booksIssued) {
            this.name = name;
            this.booksIssued = booksIssued;
        }
    }

    public static void main(String[] args) {

        IdCard ravi = new IdCard("Ravi", 0);

        // Second variable points to the SAME object
        IdCard duplicate = ravi;

        duplicate.booksIssued = 3;

        System.out.println(
                "Ravi's booksIssued (via first variable): " + ravi.booksIssued
        );

        System.out.println(
                "duplicate == ravi: " + (duplicate == ravi)
        );

        // Completely separate object with same values
        IdCard separate = new IdCard("Ravi", 3);

        System.out.println(
                "separate == ravi: " + (separate == ravi)
        );
    }
}
