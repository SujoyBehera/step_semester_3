package week8.assigment_problems;

public abstract class Assignment {
    private final String title;
    private final int maxMarks;
    private final String dueDate;

    protected Assignment(String title, int maxMarks, String dueDate) {
        if (title == null || title.trim().isEmpty()) {
            throw new IllegalArgumentException("title cannot be blank");
        }
        if (maxMarks <= 0) {
            throw new IllegalArgumentException("maxMarks must be positive");
        }
        this.title = title;
        this.maxMarks = maxMarks;
        this.dueDate = dueDate;
    }

    public String getTitle() {
        return title;
    }

    public int getMaxMarks() {
        return maxMarks;
    }

    public String getDueDate() {
        return dueDate;
    }

    public abstract double getLatePenaltyPerDay();

    public double calculatePenaltyPercentage(int lateDays) {
        if (lateDays <= 0) {
            return 0.0;
        }
        return Math.min(100.0, lateDays * getLatePenaltyPerDay());
    }

    public int calculateFinalMarks(int rawMarks, int lateDays) {
        if (rawMarks < 0) {
            throw new IllegalArgumentException("rawMarks cannot be negative");
        }
        double penaltyPct = calculatePenaltyPercentage(lateDays);
        int deduction = (int) Math.round(rawMarks * (penaltyPct / 100.0));
        return Math.max(0, rawMarks - deduction);
    }

    public static class Student extends PortalStudent {
        public Student(String name) {
            super(name);
        }
    }
}

class CodingAssignment extends Assignment {
    public CodingAssignment(String title, int maxMarks, String dueDate) {
        super(title, maxMarks, dueDate);
    }

    @Override
    public double getLatePenaltyPerDay() {
        return 10.0;
    }
}

class WrittenAssignment extends Assignment {
    public WrittenAssignment(String title, int maxMarks, String dueDate) {
        super(title, maxMarks, dueDate);
    }

    @Override
    public double getLatePenaltyPerDay() {
        return 20.0;
    }
}

enum SubmissionStatus {
    Submitted, Graded
}

class PortalStudent {
    private final String name;

    public PortalStudent(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("name cannot be blank");
        }
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

class Submission {
    private final PortalStudent student;
    private final Assignment assignment;
    private final int lateDays;
    private SubmissionStatus status = SubmissionStatus.Submitted;
    private int finalMarks = -1;

    public Submission(PortalStudent student, Assignment assignment, int lateDays) {
        if (student == null || assignment == null) {
            throw new IllegalArgumentException("student and assignment cannot be null");
        }
        this.student = student;
        this.assignment = assignment;
        this.lateDays = Math.max(0, lateDays);
    }

    public PortalStudent getStudent() {
        return student;
    }

    public Assignment getAssignment() {
        return assignment;
    }

    public int getLateDays() {
        return lateDays;
    }

    public SubmissionStatus getStatus() {
        return status;
    }

    public int getFinalMarks() {
        return finalMarks;
    }

    public String grade(int rawMarks) {
        if (status == SubmissionStatus.Graded) {
            return "Cannot grade: Submission has already been graded.";
        }
        this.status = SubmissionStatus.Graded;
        this.finalMarks = assignment.calculateFinalMarks(rawMarks, lateDays);
        if (lateDays > 0) {
            int penaltyPct = (int) assignment.calculatePenaltyPercentage(lateDays);
            return student.getName() + " graded: " + finalMarks + "/" + assignment.getMaxMarks() +
                    " after " + penaltyPct + "% late penalty. Status: Graded.";
        } else {
            return student.getName() + " graded: " + finalMarks + "/" + assignment.getMaxMarks() + ". Status: Graded.";
        }
    }

    public String resubmit() {
        if (status == SubmissionStatus.Graded) {
            return "Cannot resubmit: '" + assignment.getTitle() + "' has already been graded.";
        }
        return "Resubmission accepted for '" + assignment.getTitle() + "'.";
    }
}

class SubmissionPortal {
    public static String submit(PortalStudent student, Assignment assignment, int lateDays) {
        if (student == null || assignment == null) {
            throw new IllegalArgumentException("student and assignment cannot be null");
        }
        String timing = lateDays == 0 ? "on time" : lateDays + " days late";
        return student.getName() + "'s submission for '" + assignment.getTitle() + "' received (" + timing + "). Status: Submitted.";
    }
}
