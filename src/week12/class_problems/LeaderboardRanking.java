package week12.class_problems;

public class LeaderboardRanking {

    public static class Participant {
        public String name;
        public int score;

        public Participant(String name, int score) {
            this.name = name;
            this.score = score;
        }

        public String getName() {
            return name;
        }

        public int getScore() {
            return score;
        }
    }

    /**
     * Sorts participants in descending order of score using a stable Insertion Sort.
     * Shifts an element only while the one before it has a strictly lower score,
     * preserving original submission order for equal scores.
     *
     * Time Complexity (Sort): O(n^2) worst and average case, O(n) best case.
     * Space Complexity: O(1) auxiliary space (in-place sort).
     */
    public static void sortParticipants(Participant[] participants) {
        if (participants == null || participants.length <= 1) {
            return;
        }

        for (int i = 1; i < participants.length; i++) {
            Participant key = participants[i];
            int j = i - 1;

            while (j >= 0 && participants[j].score < key.score) {
                participants[j + 1] = participants[j];
                j--;
            }

            participants[j + 1] = key;
        }
    }

    /**
     * Formats and prints competition rankings (1, 1, 3) for an array of participants.
     *
     * Time Complexity (Printing Ranks): O(n) after sorting.
     */
    public static String[] getFormattedRanks(Participant[] participants) {
        if (participants == null || participants.length == 0) {
            return new String[0];
        }

        sortParticipants(participants);
        String[] result = new String[participants.length];
        int currentRank = 1;

        for (int i = 0; i < participants.length; i++) {
            if (i > 0 && participants[i].score != participants[i - 1].score) {
                currentRank = i + 1;
            }
            result[i] = currentRank + " " + participants[i].name + " " + participants[i].score;
        }

        return result;
    }

    public static void printRanks(Participant[] participants) {
        String[] lines = getFormattedRanks(participants);
        for (String line : lines) {
            System.out.println(line);
        }
    }
}
