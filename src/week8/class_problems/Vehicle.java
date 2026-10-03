package week8.class_problems;

import java.util.Locale;

public abstract class Vehicle {
    private final String id;
    private final String model;
    private boolean available = true;

    protected Vehicle(String id, String model) {
        if (id == null || id.trim().isEmpty()) {
            throw new IllegalArgumentException("id cannot be blank");
        }
        if (model == null || model.trim().isEmpty()) {
            throw new IllegalArgumentException("model cannot be blank");
        }
        this.id = id;
        this.model = model;
    }

    public String getId() {
        return id;
    }

    public String getModel() {
        return model;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public abstract double calculateRentalCharge(int days);

    public static class Customer extends VehicleCustomer {
        public Customer(String name) {
            super(name, name);
        }

        public Customer(String id, String name) {
            super(id, name);
        }
    }
}

class Sedan extends Vehicle {
    private static final double DAILY_RATE = 50.0;

    public Sedan(String id) {
        super(id, "Sedan");
    }

    @Override
    public double calculateRentalCharge(int days) {
        if (days <= 0) {
            throw new IllegalArgumentException("days must be positive");
        }
        return days * DAILY_RATE;
    }
}

class SUV extends Vehicle {
    private static final double DAILY_RATE = 80.0;

    public SUV(String id) {
        super(id, "SUV");
    }

    @Override
    public double calculateRentalCharge(int days) {
        if (days <= 0) {
            throw new IllegalArgumentException("days must be positive");
        }
        return days * DAILY_RATE;
    }
}

class Truck extends Vehicle {
    private static final double DAILY_RATE = 100.0;

    public Truck(String id) {
        super(id, "Truck");
    }

    @Override
    public double calculateRentalCharge(int days) {
        if (days <= 0) {
            throw new IllegalArgumentException("days must be positive");
        }
        return days * DAILY_RATE;
    }
}

class VehicleCustomer {
    private final String id;
    private final String name;

    public VehicleCustomer(String id, String name) {
        if (id == null || id.trim().isEmpty()) {
            throw new IllegalArgumentException("id cannot be blank");
        }
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("name cannot be blank");
        }
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}

class Rental {
    private final VehicleCustomer customer;
    private final Vehicle vehicle;
    private final int days;
    private final double rentalCharge;

    public Rental(VehicleCustomer customer, Vehicle vehicle, int days, double rentalCharge) {
        this.customer = customer;
        this.vehicle = vehicle;
        this.days = days;
        this.rentalCharge = rentalCharge;
    }

    public VehicleCustomer getCustomer() {
        return customer;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public int getDays() {
        return days;
    }

    public double getRentalCharge() {
        return rentalCharge;
    }
}

class VehicleRentalSystem {
    public static String rentVehicle(VehicleCustomer customer, Vehicle vehicle, int days) {
        if (customer == null || vehicle == null) {
            throw new IllegalArgumentException("Customer and vehicle cannot be null");
        }
        if (!vehicle.isAvailable()) {
            return vehicle.getId() + " is currently unavailable.";
        }
        double charge = vehicle.calculateRentalCharge(days);
        vehicle.setAvailable(false);
        new Rental(customer, vehicle, days, charge);
        return vehicle.getId() + " rented successfully by " + customer.getName() + ". Rental charge: $" + String.format(Locale.US, "%.2f", charge) + ".";
    }

    public static String returnVehicle(VehicleCustomer customer, Vehicle vehicle) {
        if (customer == null || vehicle == null) {
            throw new IllegalArgumentException("Customer and vehicle cannot be null");
        }
        vehicle.setAvailable(true);
        return vehicle.getId() + " returned by " + customer.getName() + ".";
    }
}
