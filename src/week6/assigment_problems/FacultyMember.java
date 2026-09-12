package week6.assigment_problems;

public class FacultyMember extends GymMember {
    private final String department;

    public FacultyMember(String memberId, int monthlyFee, String department) {
        super(memberId, monthlyFee);
        this.department = department;
    }

    public FacultyMember(int monthlyFee, String department) {
        super(monthlyFee);
        this.department = department;
    }

    @Override
    public String displayInfo() {
        return "Faculty Member | Department: " + department + " | Sessions: " + getSessionsAttended();
    }

    public String getDepartment() {
        return department;
    }
}
