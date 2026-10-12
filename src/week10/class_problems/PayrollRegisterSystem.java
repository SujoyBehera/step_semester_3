package week10.class_problems;

import java.util.ArrayList;
import java.util.List;

public class PayrollRegisterSystem {

    public static abstract class Staff {
        private final String name;
        private final String type;

        public Staff(String name, String type) {
            if (name == null || name.trim().isEmpty()) {
                throw new IllegalArgumentException("Staff name cannot be blank");
            }
            this.name = name;
            this.type = type;
        }

        public String getName() {
            return name;
        }

        public String getType() {
            return type;
        }

        public abstract int calculatePay();

        public String getPayslip() {
            return "Payslip[name=" + name + ", type=" + type + ", pay=" + calculatePay() + "]";
        }
    }

    public static class FullTimeStaff extends Staff {
        private final int salary;

        public FullTimeStaff(String name, int salary) {
            super(name, "FullTime");
            this.salary = salary;
        }

        @Override
        public int calculatePay() {
            return salary;
        }
    }

    public static class PartTimeStaff extends Staff {
        private final int hours;
        private final int rate;

        public PartTimeStaff(String name, int hours, int rate) {
            super(name, "PartTime");
            this.hours = hours;
            this.rate = rate;
        }

        @Override
        public int calculatePay() {
            return hours * rate;
        }
    }

    public static class InternStaff extends Staff {
        private final int stipend;

        public InternStaff(String name, int stipend) {
            super(name, "Intern");
            this.stipend = stipend;
        }

        @Override
        public int calculatePay() {
            return stipend;
        }
    }

    private final List<Staff> staffList = new ArrayList<>();

    public void addStaff(Staff staff) {
        if (staff != null) {
            staffList.add(staff);
        }
    }

    public List<String> generatePayrollReport() {
        List<String> report = new ArrayList<>();
        int totalPay = 0;
        String topEarner = "";
        int maxPay = Integer.MIN_VALUE;

        for (Staff s : staffList) {
            int pay = s.calculatePay();
            report.add(s.getPayslip());
            totalPay += pay;
            if (pay > maxPay) {
                maxPay = pay;
                topEarner = s.getName();
            }
        }

        report.add("Total " + totalPay);
        report.add("top earner " + topEarner);
        return report;
    }

    public List<String> processInputLines(List<String> lines) {
        for (String line : lines) {
            if (line == null || line.trim().isEmpty()) continue;
            String[] parts = line.trim().split("\\s+");
            String type = parts[0];
            String name = parts[1];

            if ("FullTime".equalsIgnoreCase(type)) {
                int salary = Integer.parseInt(parts[2]);
                addStaff(new FullTimeStaff(name, salary));
            } else if ("PartTime".equalsIgnoreCase(type)) {
                int hours = Integer.parseInt(parts[2]);
                int rate = Integer.parseInt(parts[3]);
                addStaff(new PartTimeStaff(name, hours, rate));
            } else if ("Intern".equalsIgnoreCase(type)) {
                int stipend = Integer.parseInt(parts[2]);
                addStaff(new InternStaff(name, stipend));
            }
        }
        return generatePayrollReport();
    }
}
