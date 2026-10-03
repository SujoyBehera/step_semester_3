package week8.assigment_problems;

import java.util.Locale;

public class WashingMachine {
    private final String machineId;
    private boolean busy;
    private WashCycle currentCycle;

    public WashingMachine(String machineId) {
        if (machineId == null || machineId.trim().isEmpty()) {
            throw new IllegalArgumentException("machineId cannot be blank");
        }
        this.machineId = machineId;
        this.busy = false;
    }

    public String getMachineId() {
        return machineId;
    }

    public boolean isBusy() {
        return busy;
    }

    public String startWash(LaundryStudent student, WashType washType) {
        if (student == null || washType == null) {
            throw new IllegalArgumentException("student and washType cannot be null");
        }
        if (this.busy) {
            return "Machine " + machineId + " is currently busy.";
        }
        this.busy = true;
        this.currentCycle = new WashCycle(student, this, washType);
        return washType.getName() + " wash started on " + machineId + " for " + student.getName() +
                " (" + washType.getDurationMinutes() + " min). Charge: ₹" +
                String.format(Locale.US, "%.2f", washType.getCharge()) + ".";
    }

    public String completeCycle() {
        if (!this.busy) {
            return "Machine " + machineId + " is not currently in use.";
        }
        this.busy = false;
        this.currentCycle = null;
        return machineId + " cycle completed. " + machineId + " is now free.";
    }

    public static class Student extends LaundryStudent {
        public Student(String name) {
            super(name);
        }
    }
}

abstract class WashType {
    private final String name;
    private final int durationMinutes;
    private final double charge;

    protected WashType(String name, int durationMinutes, double charge) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("name cannot be blank");
        }
        if (durationMinutes <= 0) {
            throw new IllegalArgumentException("durationMinutes must be positive");
        }
        if (charge < 0) {
            throw new IllegalArgumentException("charge cannot be negative");
        }
        this.name = name;
        this.durationMinutes = durationMinutes;
        this.charge = charge;
    }

    public String getName() {
        return name;
    }

    public int getDurationMinutes() {
        return durationMinutes;
    }

    public double getCharge() {
        return charge;
    }
}

class QuickWash extends WashType {
    public QuickWash() {
        super("Quick", 30, 20.0);
    }
}

class NormalWash extends WashType {
    public NormalWash() {
        super("Normal", 45, 30.0);
    }
}

class HeavyWash extends WashType {
    public HeavyWash() {
        super("Heavy", 60, 45.0);
    }
}

class DelicateWash extends WashType {
    public DelicateWash() {
        super("Delicate", 25, 25.0);
    }
}

class LaundryStudent {
    private final String name;

    public LaundryStudent(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("name cannot be blank");
        }
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

class WashCycle {
    private final LaundryStudent student;
    private final WashingMachine machine;
    private final WashType washType;

    public WashCycle(LaundryStudent student, WashingMachine machine, WashType washType) {
        this.student = student;
        this.machine = machine;
        this.washType = washType;
    }

    public LaundryStudent getStudent() {
        return student;
    }

    public WashingMachine getMachine() {
        return machine;
    }

    public WashType getWashType() {
        return washType;
    }
}
