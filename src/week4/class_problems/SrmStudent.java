package week4.class_problems;

public class SrmStudent {
    private static String collegeName;
    private static String academicYear;
    private String name;

    static {
        collegeName = "SRM Institute of Science and Technology";
        academicYear = "2026-27";
        System.out.println("College info loaded");
    }

    public SrmStudent(String name) {
        this.name = name;
    }

    public void printConfirmation() {
        System.out.println("Student record created: " + name);
    }

    public static void main(String[] args) {
        String[] names = {"Ravi", "Meera", "Karthik", "Divya", "Anitha"};
        SrmStudent[] students = new SrmStudent[names.length];

        for (int i = 0; i < names.length; i++) {
            students[i] = new SrmStudent(names[i]);
            students[i].printConfirmation();
        }
    }
}
