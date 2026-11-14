package week11.assigment_problems;

public class HackathonRegistrationDesk {

    public static class Team {
        public String name;
        public int size;

        public Team(String name, int size) {
            this.name = name;
            this.size = size;
        }

        public String getName() {
            return name;
        }

        public int getSize() {
            return size;
        }

        @Override
        public String toString() {
            return name + "(" + size + ")";
        }
    }

    /**
     * Sorts the array of teams in place by team size (smallest first) using Insertion Sort,
     * preserving the original registration order for teams of equal size.
     *
     * Time Complexity: O(n^2) worst and average case, O(n) best case (already sorted)
     * Extra Space Complexity: O(1)
     * Stable: Yes (shifts earlier teams right only when teams[j].size > key.size, preserving ties)
     */
    public static void sortTeams(Team[] teams) {
        if (teams == null || teams.length <= 1) {
            return;
        }

        for (int i = 1; i < teams.length; i++) {
            Team key = teams[i];
            int j = i - 1;

            while (j >= 0 && teams[j].size > key.size) {
                teams[j + 1] = teams[j];
                j--;
            }

            teams[j + 1] = key;
        }
    }
}
