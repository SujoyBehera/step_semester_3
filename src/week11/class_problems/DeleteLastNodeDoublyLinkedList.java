package week11.class_problems;

public class DeleteLastNodeDoublyLinkedList {

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
     * Removes the last node from a doubly linked list and returns the (possibly new) head.
     * Properly handles empty, single-node, and multi-node lists.
     * Time Complexity: O(n)
     * Extra Space Complexity: O(1)
     */
    public static DNode deleteLastNodeDoubly(DNode head) {
        if (head == null || head.next == null) {
            return null;
        }

        DNode current = head;
        while (current.next.next != null) {
            current = current.next;
        }

        DNode lastNode = current.next;
        current.next = null;
        lastNode.prev = null;

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
