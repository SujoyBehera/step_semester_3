package week5.class_problems;

import java.time.LocalDate;

public class GroupBookingReceipt {
    private final BookingReceipt receipt;
    private final int groupSize;

    public GroupBookingReceipt(BookingReceipt receipt, int groupSize) {
        this.receipt = receipt;
        this.groupSize = groupSize;
    }

    public BookingReceipt getReceipt() {
        return receipt;
    }

    public int getGroupSize() {
        return groupSize;
    }

    public static String processNightlySettlement(Object[] receipts) {
        int total = 0;
        int groups = 0;

        if (receipts != null) {
            for (Object receipt : receipts) {
                if (receipt == null) continue;
                total++;
                if (receipt instanceof GroupBookingReceipt) groups++;
            }
        }
        return "RECEIPTS=" + total + ", GROUP_RECEIPTS=" + groups;
    }

    public static void main(String[] args) {
        BookingReceipt regular = new BookingReceipt(
                "B101", "Ravi", new String[]{"A1"}, LocalDate.now());
        GroupBookingReceipt group = new GroupBookingReceipt(
                new BookingReceipt("B102", "Anitha", new String[]{"B1", "B2"}, LocalDate.now()), 2);

        System.out.println(processNightlySettlement(new Object[]{regular, group, null}));
    }
}
