package week11.class_problems;

public class ReverseFirstKNodesSinglyLinkedList {

    public static class Node {
        public int data;
        public Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    /**
     * Reverses only the first k nodes of a singly linked list while keeping
     * the remaining nodes (from k+1 onwards) in their original relative order.
     * Assumes 1 <= k <= length of the list.
     * Time Complexity: O(k)
     * Extra Space Complexity: O(1)
     */
    public static Node reverseFirstKNodes(Node head, int k) {
        if (head == null || k <= 1) {
            return head;
        }

        Node prev = null;
        Node current = head;
        Node next = null;
        int count = 0;

        while (current != null && count < k) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
            count++;
        }

        head.next = current;
        return prev;
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
