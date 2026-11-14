package week12.assigment_problems;

public class CounsellingListFirst {

    public static class Node {
        public int data;
        public Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    /**
     * Partitions a singly linked list of marks around passMark by relinking existing nodes
     * so that all marks strictly below passMark come first, followed by marks >= passMark,
     * preserving the original relative order within each group.
     *
     * Time Complexity: O(n) single pass
     * Additional Space Complexity: O(1) (relinks existing nodes in place)
     */
    public static Node partition(Node head, int passMark) {
        if (head == null) {
            return null;
        }

        Node belowHead = null;
        Node belowTail = null;
        Node passHead = null;
        Node passTail = null;

        Node current = head;
        while (current != null) {
            Node nextNode = current.next;
            current.next = null;

            if (current.data < passMark) {
                if (belowHead == null) {
                    belowHead = current;
                    belowTail = current;
                } else {
                    belowTail.next = current;
                    belowTail = current;
                }
            } else {
                if (passHead == null) {
                    passHead = current;
                    passTail = current;
                } else {
                    passTail.next = current;
                    passTail = current;
                }
            }

            current = nextNode;
        }

        if (belowHead == null) {
            return passHead;
        }

        belowTail.next = passHead;
        return belowHead;
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
