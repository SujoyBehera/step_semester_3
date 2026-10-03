package week8.class_problems;

public abstract class Employee {
    private final String name;
    private final String role;

    protected Employee(String name, String role) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("name cannot be blank");
        }
        if (role == null || role.trim().isEmpty()) {
            throw new IllegalArgumentException("role cannot be blank");
        }
        this.name = name;
        this.role = role;
    }

    public String getName() {
        return name;
    }

    public String getRole() {
        return role;
    }

    public abstract boolean canApplyForLeave(int days);
    public abstract int getMaxConsecutiveLeave();
}

class FullTimeEmployee extends Employee {
    public FullTimeEmployee(String name) {
        super(name, "Full-Time");
    }

    @Override
    public boolean canApplyForLeave(int days) {
        return days > 0 && days <= 30;
    }

    @Override
    public int getMaxConsecutiveLeave() {
        return 30;
    }
}

class PartTimeEmployee extends Employee {
    public PartTimeEmployee(String name) {
        super(name, "Part-Time");
    }

    @Override
    public boolean canApplyForLeave(int days) {
        return days > 0 && days <= 10;
    }

    @Override
    public int getMaxConsecutiveLeave() {
        return 10;
    }
}

class Contractor extends Employee {
    public Contractor(String name) {
        super(name, "Contractor");
    }

    @Override
    public boolean canApplyForLeave(int days) {
        return days > 0 && days <= 5;
    }

    @Override
    public int getMaxConsecutiveLeave() {
        return 5;
    }
}

enum LeaveStatus {
    Pending, Approved, Rejected
}

class LeaveRequest {
    private final Employee employee;
    private final String dateRange;
    private final int days;
    private LeaveStatus status = LeaveStatus.Pending;

    public LeaveRequest(Employee employee, String dateRange, int days) {
        if (employee == null) {
            throw new IllegalArgumentException("employee cannot be null");
        }
        if (dateRange == null || dateRange.trim().isEmpty()) {
            throw new IllegalArgumentException("dateRange cannot be blank");
        }
        if (days <= 0) {
            throw new IllegalArgumentException("days must be positive");
        }
        this.employee = employee;
        this.dateRange = dateRange;
        this.days = days;
    }

    public Employee getEmployee() {
        return employee;
    }

    public String getDateRange() {
        return dateRange;
    }

    public int getDays() {
        return days;
    }

    public LeaveStatus getStatus() {
        return status;
    }

    public String setStatus(LeaveStatus newStatus) {
        if (this.status != LeaveStatus.Pending && newStatus == LeaveStatus.Pending) {
            return "Cannot change leave request status from " + this.status + " to Pending.";
        }
        if (this.status != LeaveStatus.Pending) {
            return "Cannot change leave request status once " + this.status + ".";
        }
        this.status = newStatus;
        return "Status: " + this.status + ".";
    }

    public String approve() {
        if (status != LeaveStatus.Pending) {
            return "Cannot approve request with status " + status + ".";
        }
        status = LeaveStatus.Approved;
        return employee.getName() + "'s leave request (" + dateRange + ") approved. Status: Approved.";
    }

    public String reject() {
        if (status != LeaveStatus.Pending) {
            return "Cannot reject request with status " + status + ".";
        }
        status = LeaveStatus.Rejected;
        return employee.getName() + "'s leave request (" + dateRange + ") rejected. Status: Rejected.";
    }
}

class LeaveReviewer {
    private final String name;

    public LeaveReviewer(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("name cannot be blank");
        }
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String approve(LeaveRequest request) {
        if (request == null) throw new IllegalArgumentException("request cannot be null");
        return request.approve();
    }

    public String reject(LeaveRequest request) {
        if (request == null) throw new IllegalArgumentException("request cannot be null");
        return request.reject();
    }
}

class LeaveWorkflow {
    public static String submitRequest(LeaveRequest request) {
        if (request == null) throw new IllegalArgumentException("request cannot be null");
        return "Leave request submitted for " + request.getEmployee().getName() + " (" + request.getDateRange() + "). Status: Pending.";
    }
}
