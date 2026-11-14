package week12.class_problems;

public class EditorUndoHistory {

    public static class Editor {
        private final String[] history;
        private final int capacity;
        private int top;

        public Editor(int capacity) {
            if (capacity < 1) {
                throw new IllegalArgumentException("Capacity must be at least 1");
            }
            this.capacity = capacity;
            this.history = new String[capacity];
            this.top = -1;
        }

        /**
         * Adds a word to the undo history stack.
         * If the history is full, prints "rejected: history full".
         * Otherwise pushes the word and prints the current history joined by spaces.
         *
         * Time Complexity: O(1) for the stack push operation, O(N) to format/print the words.
         * Space Complexity: O(N) total storage for capacity N.
         */
        public String type(String word) {
            if (top == capacity - 1) {
                String msg = "rejected: history full";
                System.out.println(msg);
                return msg;
            }
            history[++top] = word;
            String state = currentHistoryString();
            System.out.println(state);
            return state;
        }

        /**
         * Removes the most recent word from the undo history stack.
         * If the history is empty, prints "rejected: nothing to undo".
         * Otherwise pops the top word and prints the remaining words joined by spaces, or "(empty)".
         *
         * Time Complexity: O(1) for the stack pop operation, O(N) to format/print the words.
         */
        public String undo() {
            if (top == -1) {
                String msg = "rejected: nothing to undo";
                System.out.println(msg);
                return msg;
            }
            history[top--] = null;
            String state = currentHistoryString();
            System.out.println(state);
            return state;
        }

        public String currentHistoryString() {
            if (top == -1) {
                return "(empty)";
            }
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i <= top; i++) {
                if (i > 0) {
                    sb.append(" ");
                }
                sb.append(history[i]);
            }
            return sb.toString();
        }
    }
}
