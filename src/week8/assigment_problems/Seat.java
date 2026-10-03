package week8.assigment_problems;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Set;

public abstract class Seat {
    private final String seatNumber;

    protected Seat(String seatNumber) {
        if (seatNumber == null || seatNumber.trim().isEmpty()) {
            throw new IllegalArgumentException("seatNumber cannot be blank");
        }
        this.seatNumber = seatNumber;
    }

    public String getSeatNumber() {
        return seatNumber;
    }

    public abstract double getPrice();

    public static class Customer extends TicketCustomer {
        public Customer(String name) {
            super(name);
        }
    }
}

class RegularSeat extends Seat {
    public RegularSeat(String seatNumber) {
        super(seatNumber);
    }

    @Override
    public double getPrice() {
        return 150.0;
    }
}

class PremiumSeat extends Seat {
    public PremiumSeat(String seatNumber) {
        super(seatNumber);
    }

    @Override
    public double getPrice() {
        return 250.0;
    }
}

class ReclinerSeat extends Seat {
    public ReclinerSeat(String seatNumber) {
        super(seatNumber);
    }

    @Override
    public double getPrice() {
        return 400.0;
    }
}

class TicketCustomer {
    private final String name;

    public TicketCustomer(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("name cannot be blank");
        }
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

class Show {
    private final String showName;
    private final Set<String> bookedSeatNumbers = new HashSet<>();

    public Show(String showName) {
        if (showName == null || showName.trim().isEmpty()) {
            throw new IllegalArgumentException("showName cannot be blank");
        }
        this.showName = showName;
    }

    public String getShowName() {
        return showName;
    }

    public boolean isSeatBooked(String seatNumber) {
        return bookedSeatNumbers.contains(seatNumber);
    }

    public void bookSeat(String seatNumber) {
        bookedSeatNumbers.add(seatNumber);
    }

    public void releaseSeat(String seatNumber) {
        bookedSeatNumbers.remove(seatNumber);
    }
}

class Booking {
    private final TicketCustomer customer;
    private final Show show;
    private final List<Seat> bookedSeats;
    private boolean cancelled = false;

    public Booking(TicketCustomer customer, Show show, List<Seat> bookedSeats) {
        if (customer == null || show == null || bookedSeats == null) {
            throw new IllegalArgumentException("Customer, show, and bookedSeats cannot be null");
        }
        this.customer = customer;
        this.show = show;
        this.bookedSeats = new ArrayList<>(bookedSeats);
    }

    public TicketCustomer getCustomer() {
        return customer;
    }

    public Show getShow() {
        return show;
    }

    public List<Seat> getBookedSeats() {
        return Collections.unmodifiableList(bookedSeats);
    }

    public boolean isCancelled() {
        return cancelled;
    }

    public String cancel(boolean beforeShowStarts) {
        if (!beforeShowStarts) {
            return "Cannot cancel booking after show has started.";
        }
        if (cancelled) {
            return "Booking is already cancelled.";
        }
        cancelled = true;
        List<String> releasedSeats = new ArrayList<>();
        for (Seat seat : bookedSeats) {
            show.releaseSeat(seat.getSeatNumber());
            releasedSeats.add(seat.getSeatNumber());
        }
        return customer.getName() + "'s booking cancelled. Seats " + String.join(", ", releasedSeats) + " released.";
    }
}

class TicketCounter {
    public static String bookSeats(TicketCustomer customer, Show show, List<Seat> requestedSeats) {
        if (customer == null || show == null || requestedSeats == null || requestedSeats.isEmpty()) {
            throw new IllegalArgumentException("Invalid booking request");
        }
        if (requestedSeats.size() > 6) {
            return "Cannot book more than 6 seats per booking.";
        }
        for (Seat seat : requestedSeats) {
            if (show.isSeatBooked(seat.getSeatNumber())) {
                return "Seat " + seat.getSeatNumber() + " is already booked for this show.";
            }
        }

        double total = 0.0;
        List<String> seatNumbers = new ArrayList<>();
        for (Seat seat : requestedSeats) {
            show.bookSeat(seat.getSeatNumber());
            total += seat.getPrice();
            seatNumbers.add(seat.getSeatNumber());
        }

        new Booking(customer, show, requestedSeats);
        return "Booking confirmed for " + customer.getName() + ": " + String.join(", ", seatNumbers) +
                ". Total: ₹" + String.format(Locale.US, "%.2f", total) + ".";
    }
}
