package session_1.assignment_problems;
public class M3OverloadedConstructorsforaCourse {
    public static class Course {
        String code;
        String title;
        int credits;
        int labCredits;

        Course(String code, String title, int credits, int labCredits) {
            this.code = code;
            this.title = title;
            this.credits = credits;
            this.labCredits = labCredits;
        }

        Course(String code, String title, int credits) {
            this(code, title, credits, 0);
        }

        int totalCredits() {
            return credits + labCredits;
        }
    }
    public static void main(String[] args){
        Course c1=new Course ("21CSC201J","Data Structures",4);
        Course c2=new Course("21CSC205L","DSA Lab",3,1);
        System.out.println("21CSC201J total credits:"+c1.totalCredits());
        System.out.println("21CSC205L total credits:"+c2.totalCredits());

    }
}