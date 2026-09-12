package week6.class_problems;

public class LibraryMember {
    private static int enrolled = 100;
    private final String memberNumber;
    private final String memberId;
    private final int borrowLimit;
    private int booksBorrowed;
    private final int[] fineHistory = new int[10];
    private int fineCount;

    public LibraryMember(String memberId, int borrowLimit) {
        if (memberId == null || memberId.trim().length() < 4) throw new IllegalArgumentException("Invalid memberId");
        if (borrowLimit <= 0) throw new IllegalArgumentException("borrowLimit must be positive");
        this.memberId = memberId;
        this.borrowLimit = borrowLimit;
        enrolled++;
        this.memberNumber = "LIB-" + enrolled;
    }

    public LibraryMember(int borrowLimit) {
        if (borrowLimit <= 0) throw new IllegalArgumentException("borrowLimit must be positive");
        this.memberId = null;
        this.borrowLimit = borrowLimit;
        enrolled++;
        this.memberNumber = "LIB-" + enrolled;
    }

    public void borrowBook() { booksBorrowed++; }
    public void borrowBook(String genre) { borrowBook(); }
    public int getBooksBorrowed() { return booksBorrowed; }
    public String displayInfo() { return "General Member | Books Borrowed: " + booksBorrowed; }

    protected void chargeFine(int amount) {
        if (fineCount < fineHistory.length) fineHistory[fineCount++] = amount;
    }
    public int[] getFineHistory() {
        int[] copy = new int[fineCount];
        System.arraycopy(fineHistory, 0, copy, 0, fineCount);
        return copy;
    }
    public int getTotalFine() {
        int total = 0;
        for (int i = 0; i < fineCount; i++) total += fineHistory[i];
        return total;
    }

    public static String enrollBatch(String[] memberIds, int borrowLimit) {
        int enrolledCount = 0, rejected = 0;
        if (memberIds != null) for (String id : memberIds) {
            try { new LibraryMember(id, borrowLimit); enrolledCount++; }
            catch (IllegalArgumentException e) { rejected++; }
        }
        return "Enrolled: " + enrolledCount + " | Rejected: " + rejected;
    }

    public static boolean isValidRenewalCode(String code) {
        if (code == null || code.length() != 4) return false;
        return code.charAt(0) == 'R' && Character.isDigit(code.charAt(1))
                && Character.isDigit(code.charAt(2)) && Character.isUpperCase(code.charAt(3));
    }
    public static int getMembersEnrolled() { return enrolled - 100; }
    public String getMemberNumber() { return memberNumber; }
}
