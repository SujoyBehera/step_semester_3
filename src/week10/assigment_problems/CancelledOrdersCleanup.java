package week10.assigment_problems;

public class CancelledOrdersCleanup {

    public static class Node {
        public int data;
        public Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    /**
     * Removes every node with the given code and returns the (possibly new) head.
     * Time Complexity: O(n) where n is the number of nodes in the list.
     * Space Complexity: O(1) auxiliary space.
     */
    public static Node removeAll(Node head, int code) {
        // Step 1: Remove matching nodes from the front
        while (head != null && head.data == code) {
            head = head.next;
        }

        if (head == null) {
            return null;
        }

        // Step 2: Traverse and skip matching nodes
        Node curr = head;
        while (curr.next != null) {
            if (curr.next.data == code) {
                curr.next = curr.next.next;
            } else {
                curr = curr.next;
            }
        }

        return head;
    }

    public static String printList(Node head) {
        if (head == null) {
            return "null";
        }
        StringBuilder sb = new StringBuilder();
        Node curr = head;
        while (curr != null) {
            sb.append(curr.data).append(" -> ");
            curr = curr.next;
        }
        sb.append("null");
        return sb.toString();
    }
}
