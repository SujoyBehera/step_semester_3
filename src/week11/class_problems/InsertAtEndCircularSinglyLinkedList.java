package week11.class_problems;

public class InsertAtEndCircularSinglyLinkedList {

    public static class Node {
        public int data;
        public Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    /**
     * Inserts a new node with the given value at the logical end of a circular singly linked list
     * and returns the (possibly new) head of the list.
     * Time Complexity: O(n)
     * Extra Space Complexity: O(1)
     */
    public static Node insertAtEndCircular(Node head, int value) {
        Node newNode = new Node(value);
        if (head == null) {
            newNode.next = newNode;
            return newNode;
        }

        Node current = head;
        while (current.next != head) {
            current = current.next;
        }

        current.next = newNode;
        newNode.next = head;
        return head;
    }

    public static String formatCircular(Node head) {
        if (head == null) {
            return "(empty list)";
        }
        StringBuilder sb = new StringBuilder();
        Node curr = head;
        do {
            sb.append(curr.data).append(" -> ");
            curr = curr.next;
        } while (curr != head);
        sb.append("(back to ").append(head.data).append(")");
        return sb.toString();
    }
}
