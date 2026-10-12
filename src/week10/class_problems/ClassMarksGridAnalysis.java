package week10.class_problems;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class ClassMarksGridAnalysis {

    public static class StudentRecord {
        private final String name;
        private final int[] marks;

        public StudentRecord(String name, int[] marks) {
            if (name == null || name.trim().isEmpty()) {
                throw new IllegalArgumentException("Student name cannot be blank");
            }
            if (marks == null) {
                throw new IllegalArgumentException("Marks cannot be null");
            }
            this.name = name;
            this.marks = marks.clone();
        }

        public String getName() {
            return name;
        }

        public int[] getMarks() {
            return marks.clone();
        }

        public int getTotalMarks() {
            int sum = 0;
            for (int m : marks) sum += m;
            return sum;
        }
    }

    public static class AnalysisResult {
        private final List<String> totalsFormatted;
        private final double[] subjectAverages;
        private final String topperName;
        private final int topperMarks;

        public AnalysisResult(List<String> totalsFormatted, double[] subjectAverages, String topperName, int topperMarks) {
            this.totalsFormatted = totalsFormatted;
            this.subjectAverages = subjectAverages;
            this.topperName = topperName;
            this.topperMarks = topperMarks;
        }

        public String getTotalsLine() {
            return "Totals " + String.join(", ", totalsFormatted);
        }

        public String getAveragesLine() {
            List<String> avgs = new ArrayList<>();
            for (double avg : subjectAverages) {
                avgs.add(String.format(Locale.US, "%.2f", avg));
            }
            return "averages " + String.join(", ", avgs);
        }

        public String getTopperLine() {
            return "topper " + topperName + " (" + topperMarks + ")";
        }

        public List<String> getAllLines() {
            List<String> lines = new ArrayList<>();
            lines.add(getTotalsLine());
            lines.add(getAveragesLine());
            lines.add(getTopperLine());
            return lines;
        }
    }

    public static AnalysisResult analyze(List<StudentRecord> students) {
        if (students == null || students.isEmpty()) {
            throw new IllegalArgumentException("Students list cannot be empty");
        }

        int numSubjects = students.get(0).getMarks().length;
        double[] subjectSums = new double[numSubjects];
        List<String> totalsList = new ArrayList<>();

        String topperName = "";
        int maxTotal = Integer.MIN_VALUE;

        for (StudentRecord student : students) {
            int total = student.getTotalMarks();
            totalsList.add(student.getName() + " " + total);

            if (total > maxTotal) {
                maxTotal = total;
                topperName = student.getName();
            }

            int[] marks = student.getMarks();
            for (int j = 0; j < numSubjects; j++) {
                subjectSums[j] += marks[j];
            }
        }

        double[] subjectAverages = new double[numSubjects];
        for (int j = 0; j < numSubjects; j++) {
            subjectAverages[j] = subjectSums[j] / students.size();
        }

        return new AnalysisResult(totalsList, subjectAverages, topperName, maxTotal);
    }

    public static AnalysisResult analyzeFromInputLines(List<String> lines) {
        List<StudentRecord> students = new ArrayList<>();
        for (String line : lines) {
            if (line == null || line.trim().isEmpty()) continue;
            // Format: Asha [78, 85, 90]
            int bracketStart = line.indexOf('[');
            int bracketEnd = line.indexOf(']');
            String name = line.substring(0, bracketStart).trim();
            String marksStr = line.substring(bracketStart + 1, bracketEnd);
            String[] markParts = marksStr.split(",");
            int[] marks = new int[markParts.length];
            for (int i = 0; i < markParts.length; i++) {
                marks[i] = Integer.parseInt(markParts[i].trim());
            }
            students.add(new StudentRecord(name, marks));
        }
        return analyze(students);
    }
}
