package week6.class_problems;

public class StudentMember extends LibraryMember {
    private final String course;

    public StudentMember(String memberId, int borrowLimit, String course) {
        super(memberId, borrowLimit);
        this.course = course;
    }

    @Override
    public String displayInfo() {
        return "Student Member | Course: " + course + " | Books Borrowed: " + getBooksBorrowed();
    }

    @Override
    protected void chargeFine(int amount) { super.chargeFine(amount / 2); }
    public String getCourse() { return course; }
}
