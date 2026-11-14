package week11.class_problems;

public class CheckIfSinglyLinkedListIsEmpty {

    public static class Node {
        public int data;
        public Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    /**
     * Returns true if the singly linked list is empty (head is null), and false otherwise.
     * Time Complexity: O(1)
     * Extra Space Complexity: O(1)
     */
    public static boolean checkIfEmpty(Node head) {
        return head == null;
    }
}
