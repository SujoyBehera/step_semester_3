package week5.assigment_problems;

import java.util.Arrays;

/**
 * Immutable receipt value object.
 *
 * Note: the supplied assignment simultaneously requires this class to be
 * final and requires ReferenceOnlyLoanReceipt to extend it. Java cannot
 * satisfy both requirements, so the inheritance requirement is prioritized
 * to keep the requested polymorphic design compilable.
 */
public class LoanReceipt {
    private final String memberId;
    private final String[] bookIds;

    public LoanReceipt(String memberId, String[] bookIds) {
        this.memberId = memberId;
        this.bookIds = bookIds == null ? new String[0] : Arrays.copyOf(bookIds, bookIds.length);
    }

    public String getMemberId() {
        return memberId;
    }

    public String[] getBookIds() {
        return Arrays.copyOf(bookIds, bookIds.length);
    }

    public LoanReceipt withCorrectedBookId(int index, String newId) {
        if (index < 0 || index >= bookIds.length) {
            throw new IndexOutOfBoundsException("Invalid book ID index");
        }
        String[] corrected = Arrays.copyOf(bookIds, bookIds.length);
        corrected[index] = newId;
        return new LoanReceipt(memberId, corrected);
    }
}
