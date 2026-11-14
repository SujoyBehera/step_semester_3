package week12.assigment_problems;

public class MergingTwoWaitlists {

    public static class Node {
        public int data;
        public Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    /**
     * Merges two sorted singly linked lists into one sorted waitlist by relinking
     * existing nodes using a single dummy head node.
     *
     * Time Complexity: O(n + m) where n and m are the lengths of the two lists.
     * Additional Space Complexity: O(1) (only one dummy node and pointer variables allocated).
     */
    public static Node merge(Node first, Node second) {
        Node dummy = new Node(0);
        Node tail = dummy;

        while (first != null && second != null) {
            if (first.data <= second.data) {
                tail.next = first;
                first = first.next;
            } else {
                tail.next = second;
                second = second.next;
            }
            tail = tail.next;
        }

        if (first != null) {
            tail.next = first;
        } else {
            tail.next = second;
        }

        return dummy.next;
    }

    public static String formatList(Node head) {
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
