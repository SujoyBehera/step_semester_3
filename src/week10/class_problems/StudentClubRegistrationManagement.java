package week10.class_problems;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

public class StudentClubRegistrationManagement {

    public static class StudentMember {
        private final String rollNumber;
        private final String name;

        public StudentMember(String rollNumber, String name) {
            if (rollNumber == null || rollNumber.trim().isEmpty()) {
                throw new IllegalArgumentException("Roll number cannot be blank");
            }
            if (name == null || name.trim().isEmpty()) {
                throw new IllegalArgumentException("Name cannot be blank");
            }
            this.rollNumber = rollNumber;
            this.name = name;
        }

        public String getRollNumber() {
            return rollNumber;
        }

        public String getName() {
            return name;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            StudentMember that = (StudentMember) o;
            return Objects.equals(rollNumber, that.rollNumber);
        }

        @Override
        public int hashCode() {
            return Objects.hash(rollNumber);
        }
    }

    private final Set<StudentMember> members = new HashSet<>();

    public String addMember(String rollNumber, String name) {
        StudentMember member = new StudentMember(rollNumber, name);
        if (members.add(member)) {
            return "Added";
        } else {
            return "duplicate rejected";
        }
    }

    public boolean containsMember(String rollNumber) {
        return members.contains(new StudentMember(rollNumber, "dummy"));
    }

    public int getMemberCount() {
        return members.size();
    }

    public List<String> processOperations(List<String> operations) {
        List<String> results = new ArrayList<>();
        if (operations == null) return results;

        boolean printedCount = false;

        for (String op : operations) {
            if (op == null || op.trim().isEmpty()) continue;
            String[] parts = op.trim().split("\\s+");
            String command = parts[0];

            if ("ADD".equalsIgnoreCase(command)) {
                results.add(addMember(parts[1], parts[2]));
            } else if ("CONTAINS".equalsIgnoreCase(command)) {
                if (!printedCount) {
                    results.add("member count " + getMemberCount());
                    printedCount = true;
                }
                boolean exists = containsMember(parts[1]);
                results.add("contains: " + exists);
            }
        }
        return results;
    }
}
