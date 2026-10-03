package week8.class_problems;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public abstract class Room {
    private final String roomNumber;
    private final String roomType;
    private final List<Reservation> activeReservations = new ArrayList<>();

    protected Room(String roomNumber, String roomType) {
        if (roomNumber == null || roomNumber.trim().isEmpty()) {
            throw new IllegalArgumentException("roomNumber cannot be blank");
        }
        if (roomType == null || roomType.trim().isEmpty()) {
            throw new IllegalArgumentException("roomType cannot be blank");
        }
        this.roomNumber = roomNumber;
        this.roomType = roomType;
    }

    public String getRoomNumber() {
        return roomNumber;
    }

    public String getRoomType() {
        return roomType;
    }

    public String getDisplayName() {
        return roomType + " " + roomNumber;
    }

    public abstract double calculatePrice(int nights);

    public boolean isAvailable(String period) {
        for (Reservation res : activeReservations) {
            if (res.isActive() && res.overlapsWith(period)) {
                return false;
            }
        }
        return true;
    }

    public void addReservation(Reservation res) {
        if (res != null) {
            activeReservations.add(res);
        }
    }

    public void removeReservation(Reservation res) {
        activeReservations.remove(res);
    }

    public static class Customer extends HotelCustomer {
        public Customer(String name) {
            super(name);
        }
    }
}

class StandardRoom extends Room {
    private static final double RATE_PER_NIGHT = 100.0;

    public StandardRoom(String roomNumber) {
        super(roomNumber, "Standard Room");
    }

    @Override
    public double calculatePrice(int nights) {
        if (nights <= 0) {
            throw new IllegalArgumentException("nights must be positive");
        }
        return nights * RATE_PER_NIGHT;
    }
}

class DeluxeRoom extends Room {
    private static final double RATE_PER_NIGHT = 150.0;

    public DeluxeRoom(String roomNumber) {
        super(roomNumber, "Deluxe Room");
    }

    @Override
    public double calculatePrice(int nights) {
        if (nights <= 0) {
            throw new IllegalArgumentException("nights must be positive");
        }
        return nights * RATE_PER_NIGHT;
    }
}

class Suite extends Room {
    private static final double RATE_PER_NIGHT = 250.0;

    public Suite(String roomNumber) {
        super(roomNumber, "Suite");
    }

    @Override
    public double calculatePrice(int nights) {
        if (nights <= 0) {
            throw new IllegalArgumentException("nights must be positive");
        }
        return nights * RATE_PER_NIGHT;
    }
}

class HotelCustomer {
    private final String name;

    public HotelCustomer(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("name cannot be blank");
        }
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

class Reservation {
    private final HotelCustomer customer;
    private final Room room;
    private final String period;
    private final int nights;
    private final double price;
    private boolean active = true;

    public Reservation(HotelCustomer customer, Room room, String period, int nights, double price) {
        if (customer == null || room == null) {
            throw new IllegalArgumentException("Customer and room cannot be null");
        }
        if (period == null || period.trim().isEmpty()) {
            throw new IllegalArgumentException("period cannot be blank");
        }
        if (nights <= 0) {
            throw new IllegalArgumentException("nights must be positive");
        }
        this.customer = customer;
        this.room = room;
        this.period = period;
        this.nights = nights;
        this.price = price;
    }

    public HotelCustomer getCustomer() {
        return customer;
    }

    public Room getRoom() {
        return room;
    }

    public String getPeriod() {
        return period;
    }

    public int getNights() {
        return nights;
    }

    public double getPrice() {
        return price;
    }

    public boolean isActive() {
        return active;
    }

    public boolean overlapsWith(String otherPeriod) {
        if (!active || otherPeriod == null) return false;
        return true;
    }

    public String cancel(boolean beforeDeadline) {
        if (!beforeDeadline) {
            return "Cannot cancel reservation: Cancellation deadline has passed.";
        }
        active = false;
        room.removeReservation(this);
        return "Reservation for " + customer.getName() + ", " + room.getDisplayName() + " (" + period + ") cancelled successfully.";
    }
}

class HotelBookingSystem {
    public static String checkAvailability(Room room, String period) {
        if (room == null || period == null) {
            throw new IllegalArgumentException("room and period cannot be null");
        }
        if (room.isAvailable(period)) {
            return room.getDisplayName() + " is available from " + period + ".";
        } else {
            return room.getDisplayName() + " is not available from " + period + ".";
        }
    }

    public static String reserveRoom(HotelCustomer customer, Room room, String period, int nights) {
        if (customer == null || room == null) {
            throw new IllegalArgumentException("Customer and room cannot be null");
        }
        if (!room.isAvailable(period)) {
            return room.getDisplayName() + " is not available from " + period + ".";
        }
        double price = room.calculatePrice(nights);
        Reservation res = new Reservation(customer, room, period, nights, price);
        room.addReservation(res);
        return "Reservation confirmed for " + customer.getName() + ", " + room.getDisplayName() + " (" + period + "). Price: $" + String.format(Locale.US, "%.2f", price) + ".";
    }
}
