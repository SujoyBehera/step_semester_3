package week5.assigment_problems;

public final class ReferenceOnlyLoanReceipt {
    private final LoanReceipt receipt;
    private final String roomNumber;

    public ReferenceOnlyLoanReceipt(String memberId, String[] bookIds, String roomNumber) {
        this.receipt = new LoanReceipt(memberId, bookIds);
        this.roomNumber = roomNumber;
    }

    public String getMemberId() {
        return receipt.getMemberId();
    }

    public String[] getBookIds() {
        return receipt.getBookIds();
    }

    public String getRoomNumber() {
        return roomNumber;
    }
}
