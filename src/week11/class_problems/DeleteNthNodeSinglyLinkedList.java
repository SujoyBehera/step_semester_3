package week11.class_problems;

public class DeleteNthNodeSinglyLinkedList {

    public static class Node {
        public int data;
        public Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    /**
     * Deletes the node at the 1-based n-th position and returns the head of the modified list.
     * Assumes 1 <= n <= length of list.
     * Time Complexity: O(n)
     * Extra Space Complexity: O(1)
     */
    public static Node deleteNthNode(Node head, int n) {
        if (head == null || n <= 0) {
            return head;
        }
        if (n == 1) {
            return head.next;
        }

        Node current = head;
        for (int i = 0; i < n - 2 && current != null; i++) {
            current = current.next;
        }

        if (current != null && current.next != null) {
            current.next = current.next.next;
        }
        return head;
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
