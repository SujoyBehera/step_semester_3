package week12.class_problems;

import java.util.ArrayList;
import java.util.List;

public class SectionTimetables {

    public static class Timetable {
        private String sectionName;
        private final List<String> periods;

        public Timetable(String sectionName, List<String> periods) {
            this.sectionName = sectionName;
            this.periods = new ArrayList<>(periods);
        }

        public Timetable(List<String> periods) {
            this("", periods);
        }

        public String getSectionName() {
            return sectionName;
        }

        public void setSectionName(String sectionName) {
            this.sectionName = sectionName;
        }

        public List<String> getPeriods() {
            return new ArrayList<>(periods);
        }

        /**
         * Creates a deep copy of this Timetable with a separate list of periods.
         *
         * Time Complexity of copy(): O(p) where p is the number of periods.
         * Space Complexity of copy(): O(p) to allocate the new ArrayList of periods.
         */
        public Timetable copy() {
            return new Timetable(this.sectionName, new ArrayList<>(this.periods));
        }

        public Timetable copy(String newSectionName) {
            return new Timetable(newSectionName, new ArrayList<>(this.periods));
        }

        /**
         * Updates the subject at the given 1-based period number.
         */
        public void setPeriod(int period, String subject) {
            if (period < 1 || period > periods.size()) {
                throw new IndexOutOfBoundsException("Period out of range: " + period);
            }
            periods.set(period - 1, subject);
        }

        @Override
        public String toString() {
            if (sectionName == null || sectionName.isEmpty()) {
                return periods.toString();
            }
            return sectionName + ": " + periods.toString();
        }
    }
}
