package week12.assigment_problems;

public class MiddleSeatFinder {

    public static class Node {
        public int data;
        public Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    /**
     * Finds the middle seat number in a single pass using slow and fast pointers.
     * For an even number of seats, returns the second of the two middle seats.
     *
     * Time Complexity: O(n)
     * Additional Space Complexity: O(1)
     * Nodes visited by fast pointer: floor(n / 2) + 1 positions (starting at head and jumping
     * 2 nodes per step; for odd n it stops at the tail node after (n - 1) / 2 jumps, and for
     * even n it reaches null after n / 2 jumps).
     */
    public static int middle(Node head) {
        if (head == null) {
            throw new IllegalArgumentException("Seat list cannot be empty");
        }

        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow.data;
    }

    public static String formatMiddle(Node head) {
        return "Middle: " + middle(head);
    }
}
