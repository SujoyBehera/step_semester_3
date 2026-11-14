package week11.class_problems;

public class SplitSinglyLinkedListIntoTwoHalves {

    public static class Node {
        public int data;
        public Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    /**
     * Splits a singly linked list into two halves using the fast and slow pointer technique.
     * If the list has an odd number of nodes, the first half contains the extra middle node.
     * Terminates the first half (last node's next = null) and returns the head of the second half.
     * Time Complexity: O(n)
     * Space Complexity: O(1) extra space
     */
    public static Node splitListInHalf(Node head) {
        if (head == null || head.next == null) {
            return null;
        }

        Node slow = head;
        Node fast = head;
        Node prevOfSlow = null;

        while (fast != null && fast.next != null) {
            prevOfSlow = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        if (fast != null) {
            prevOfSlow = slow;
            slow = slow.next;
        }

        if (prevOfSlow != null) {
            prevOfSlow.next = null;
        }

        return slow;
    }

    public static String formatList(Node head) {
        if (head == null) {
            return "(empty list)";
        }
        StringBuilder sb = new StringBuilder();
        Node curr = head;
        while (curr != null) {
            if (sb.length() > 0) {
                sb.append(" -> ");
            }
            sb.append(curr.data);
            curr = curr.next;
        }
        return sb.toString();
    }
}
