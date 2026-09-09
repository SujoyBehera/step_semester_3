package week5.class_problems;

import java.time.LocalDate;
import java.util.Arrays;

public final class BookingReceipt {
    private final String bookingId;
    private final String customerName;
    private final String[] seats;
    private final LocalDate bookingDate;

    public BookingReceipt(String bookingId, String customerName, String[] seats, LocalDate bookingDate) {
        this.bookingId = bookingId;
        this.customerName = customerName;
        this.seats = seats == null ? new String[0] : seats.clone();
        this.bookingDate = bookingDate;
    }

    public String getBookingId() { return bookingId; }
    public String getCustomerName() { return customerName; }
    public String[] getSeats() { return seats.clone(); }
    public LocalDate getBookingDate() { return bookingDate; }

    public BookingReceipt withUpdatedSeat(int index, String newSeat) {
        String[] updatedSeats = seats.clone();
        if (index < 0 || index >= updatedSeats.length) {
            throw new IndexOutOfBoundsException("Invalid seat index: " + index);
        }
        updatedSeats[index] = newSeat;
        return new BookingReceipt(bookingId, customerName, updatedSeats, bookingDate);
    }

    @Override
    public String toString() {
        return "BookingReceipt{" +
                "bookingId='" + bookingId + '\'' +
                ", customerName='" + customerName + '\'' +
                ", seats=" + Arrays.toString(seats) +
                ", bookingDate=" + bookingDate +
                '}';
    }
}
