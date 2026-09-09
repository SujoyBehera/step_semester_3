package week5.assigment_problems;

import week5.class_problems.BookingReceipt;

public class GroupBookingReceipt extends BookingReceipt {
    private final int groupSize;

    public GroupBookingReceipt(String bookingId, String customerName, String[] seats,
                               java.time.LocalDate bookingDate, int groupSize) {
        super(bookingId, customerName, seats, bookingDate);
        this.groupSize = groupSize;
    }

    public int getGroupSize() {
        return groupSize;
    }

    public static String processNightlySettlement(BookingReceipt[] receipts) {
        int total = 0;
        int groups = 0;

        if (receipts != null) {
            for (BookingReceipt receipt : receipts) {
                if (receipt == null) continue;
                total++;
                if (receipt instanceof GroupBookingReceipt) groups++;
            }
        }
        return "RECEIPTS=" + total + ", GROUP_RECEIPTS=" + groups;
    }
}
