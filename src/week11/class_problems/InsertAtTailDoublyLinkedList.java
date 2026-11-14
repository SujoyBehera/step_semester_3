package week11.class_problems;

public class InsertAtTailDoublyLinkedList {

    public static class DNode {
        public int data;
        public DNode prev;
        public DNode next;

        public DNode(int data) {
            this.data = data;
            this.prev = null;
            this.next = null;
        }
    }

    /**
     * Inserts a new node with the given value at the tail of a doubly linked list
     * and returns the (possibly new) head of the list.
     * Time Complexity: O(n)
     * Extra Space Complexity: O(1)
     */
    public static DNode insertAtTailDoubly(DNode head, int value) {
        DNode newNode = new DNode(value);
        if (head == null) {
            return newNode;
        }

        DNode current = head;
        while (current.next != null) {
            current = current.next;
        }

        current.next = newNode;
        newNode.prev = current;
        return head;
    }

    public static String formatDoubly(DNode head) {
        if (head == null) {
            return "(empty list)";
        }
        StringBuilder sb = new StringBuilder();
        DNode curr = head;
        while (curr != null) {
            if (sb.length() > 0) {
                sb.append(" <-> ");
            }
            sb.append(curr.data);
            curr = curr.next;
        }
        return sb.toString();
    }
}
