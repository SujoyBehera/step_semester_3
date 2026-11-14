package week11.class_problems;

public class RemoveFirstKNodesSinglyLinkedList {

    public static class Node {
        public int data;
        public Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    /**
     * Removes the first k nodes from a singly linked list and returns the new head.
     * If k is greater than or equal to the length of the list, returns null.
     * Time Complexity: O(min(k, n))
     * Extra Space Complexity: O(1)
     */
    public static Node removeFirstKNodes(Node head, int k) {
        if (head == null || k <= 0) {
            return head;
        }

        Node current = head;
        for (int i = 0; i < k && current != null; i++) {
            current = current.next;
        }
        return current;
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
