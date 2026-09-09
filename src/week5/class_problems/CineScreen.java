package week5.class_problems;

public class CineScreen {
    private final int seatsTotal;
    private int seatsAvailable;

    public CineScreen(int seatsTotal) {
        if (seatsTotal <= 0) {
            throw new IllegalArgumentException("seatsTotal must be greater than 0");
        }
        this.seatsTotal = seatsTotal;
        this.seatsAvailable = seatsTotal;
    }

    public boolean bookSeat() {
        if (seatsAvailable <= 0) return false;
        seatsAvailable--;
        return true;
    }

    public boolean cancelBooking() {
        if (seatsAvailable >= seatsTotal) return false;
        seatsAvailable++;
        return true;
    }

    public int getSeatsAvailable() {
        return seatsAvailable;
    }
}
