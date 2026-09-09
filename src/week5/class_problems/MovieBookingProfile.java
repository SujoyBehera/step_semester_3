package week5.class_problems;

public class MovieBookingProfile {
    private String customerName;
    private String movieName;
    private int seatsBooked;
    private boolean confirmed;
    private String otp;

    public MovieBookingProfile() {
        this("", "", 0, false);
    }

    public MovieBookingProfile(String customerName, String movieName, int seatsBooked, boolean confirmed) {
        this.customerName = customerName;
        this.movieName = movieName;
        this.seatsBooked = seatsBooked;
        this.confirmed = confirmed;
    }

    public String getCustomerName() { return customerName; }
    public void setCustomerName(String customerName) { this.customerName = customerName; }
    public String getMovieName() { return movieName; }
    public void setMovieName(String movieName) { this.movieName = movieName; }
    public int getSeatsBooked() { return seatsBooked; }
    public void setSeatsBooked(int seatsBooked) { this.seatsBooked = seatsBooked; }
    public boolean isConfirmed() { return confirmed; }
    public void setConfirmed(boolean confirmed) { this.confirmed = confirmed; }
    public void setOtp(String otp) { this.otp = otp; }
}
