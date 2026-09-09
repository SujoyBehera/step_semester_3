package week4.class_problems;

public class Employee {
    private String employeeId;
    private double salary;

    public Employee(String employeeId, double salary) {
        this.employeeId = employeeId;
        this.salary = salary;
    }

    public void raiseSalary(double salary) {
        this.salary += salary;
    }

    public void printSalary() {
        System.out.println(employeeId + " | Final Salary: Rs " + salary);
    }

    public static void main(String[] args) {
        String[] ids = {"E-101", "E-102", "E-103", "E-104"};
        double[] salaries = {40000, 55000, 62000, 48000};
        double bonus = 5000;

        for (int i = 0; i < ids.length; i++) {
            Employee employee = new Employee(ids[i], salaries[i]);
            employee.raiseSalary(bonus);
            employee.printSalary();
        }
    }
}
