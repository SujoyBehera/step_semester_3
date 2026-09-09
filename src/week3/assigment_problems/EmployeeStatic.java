package week3.assigment_problems;

public class EmployeeStatic {
    String empName;
    double salary;
    static String companyName = "Bright Horizon Technologies";
    static int employeeCount = 0;

    public EmployeeStatic(String empName, double salary) {
        this.empName = empName;
        this.salary = salary;
        employeeCount++;
    }

    public static void printCompanyInfo() {
        System.out.println(companyName);
        System.out.println("Employees on record: " + employeeCount);
    }

    public static void main(String[] args) {
        new EmployeeStatic("Divya", 65000);
        new EmployeeStatic("Arjun", 30000);
        new EmployeeStatic("Priya", 55000);
        EmployeeStatic.printCompanyInfo();
    }
}
