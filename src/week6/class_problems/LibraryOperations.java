package week6.class_problems;

public class LibraryOperations {
    public static String classifyGeneration(LibraryMember member) {
        if (member instanceof HonorsStudentMember) return "Multilevel descendant (3 generations deep)";
        if (member instanceof FacultyMember) return "Hierarchical sibling (independent branch)";
        if (member instanceof StudentMember) return "Multilevel descendant (2 generations deep)";
        if (member instanceof LibraryMember) return "Base member";
        return "Unknown";
    }

    public static int getTotalBooksBorrowed(LibraryMember[] members) {
        int total = 0;
        if (members != null) for (LibraryMember member : members) if (member != null) total += member.getBooksBorrowed();
        return total;
    }

    public static String batchPrint(LibraryMember[] members) {
        StringBuilder result = new StringBuilder();
        for (LibraryMember member : members) {
            result.append(member.displayInfo());
            if (member instanceof StudentMember) {
                StudentMember student = (StudentMember) member;
                result.append(" [Course via downcast: ").append(student.getCourse()).append("]");
            }
            result.append(" | ");
        }
        return result.toString();
    }

    public static String processNightlyAudit(LibraryMember[] members) {
        int processed = 0, nullSkipped = 0, faculty = 0, regular = 0;
        if (members != null) for (LibraryMember member : members) {
            if (member == null) { nullSkipped++; continue; }
            processed++;
            if (member instanceof FacultyMember) faculty++; else regular++;
        }
        return processed + " processed | " + nullSkipped + " null skipped | " + faculty + " faculty | " + regular + " regular";
    }
}
