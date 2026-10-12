package week10.class_problems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CampusVehiclePassSystem {

    public interface ChargeableVehicle {
        String bookChargingBay();
    }

    public static abstract class Vehicle {
        private final String passNumber;
        private final String ownerName;
        private final String typeName;

        public Vehicle(String passNumber, String ownerName, String typeName) {
            if (passNumber == null || passNumber.trim().isEmpty()) {
                throw new IllegalArgumentException("Pass number cannot be blank");
            }
            if (ownerName == null || ownerName.trim().isEmpty()) {
                throw new IllegalArgumentException("Owner name cannot be blank");
            }
            this.passNumber = passNumber;
            this.ownerName = ownerName;
            this.typeName = typeName;
        }

        public String getPassNumber() {
            return passNumber;
        }

        public String getOwnerName() {
            return ownerName;
        }

        public String getTypeName() {
            return typeName;
        }

        public abstract int getPassFee();

        public String getPassDetails() {
            return passNumber + " (" + typeName + ") pass fee " + getPassFee();
        }
    }

    public static class Bike extends Vehicle {
        public Bike(String passNumber, String ownerName) {
            super(passNumber, ownerName, "Bike");
        }

        @Override
        public int getPassFee() {
            return 300;
        }
    }

    public static class Car extends Vehicle {
        public Car(String passNumber, String ownerName) {
            super(passNumber, ownerName, "Car");
        }

        @Override
        public int getPassFee() {
            return 1000;
        }
    }

    public static class EBike extends Vehicle implements ChargeableVehicle {
        public EBike(String passNumber, String ownerName) {
            super(passNumber, ownerName, "EBike");
        }

        @Override
        public int getPassFee() {
            return 300;
        }

        @Override
        public String bookChargingBay() {
            return getPassNumber() + " charging bay allotted";
        }
    }

    public static class ECar extends Vehicle implements ChargeableVehicle {
        public ECar(String passNumber, String ownerName) {
            super(passNumber, ownerName, "ECar");
        }

        @Override
        public int getPassFee() {
            return 1000;
        }

        @Override
        public String bookChargingBay() {
            return getPassNumber() + " charging bay allotted";
        }
    }

    private final Map<String, Vehicle> vehicles = new HashMap<>();

    public String registerVehicle(String type, String passNumber, String ownerName) {
        Vehicle vehicle;
        if ("Bike".equalsIgnoreCase(type)) {
            vehicle = new Bike(passNumber, ownerName);
        } else if ("Car".equalsIgnoreCase(type)) {
            vehicle = new Car(passNumber, ownerName);
        } else if ("EBike".equalsIgnoreCase(type)) {
            vehicle = new EBike(passNumber, ownerName);
        } else if ("ECar".equalsIgnoreCase(type)) {
            vehicle = new ECar(passNumber, ownerName);
        } else {
            throw new IllegalArgumentException("Unknown vehicle type: " + type);
        }
        vehicles.put(passNumber, vehicle);
        return vehicle.getPassDetails();
    }

    public String chargeVehicle(String passNumber) {
        Vehicle vehicle = vehicles.get(passNumber);
        if (vehicle == null) {
            return passNumber + " not found";
        }
        if (vehicle instanceof ChargeableVehicle) {
            return ((ChargeableVehicle) vehicle).bookChargingBay();
        } else {
            return passNumber + " rejected: charging unsupported";
        }
    }

    public List<String> processOperations(List<String> operations) {
        List<String> results = new ArrayList<>();
        if (operations == null) return results;

        for (String op : operations) {
            if (op == null || op.trim().isEmpty()) continue;
            String[] parts = op.trim().split("\\s+");
            String command = parts[0];

            if ("PASS".equalsIgnoreCase(command)) {
                String type = parts[1];
                String passNum = parts[2];
                String owner = parts[3];
                results.add(registerVehicle(type, passNum, owner));
            } else if ("CHARGE".equalsIgnoreCase(command)) {
                String passNum = parts[1];
                results.add(chargeVehicle(passNum));
            }
        }
        return results;
    }
}
