package week10.assigment_problems;

public class PriorityTokenInsertion {

    public static class Node {
        public int data;
        public Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    private Node head;
    private int size;

    public PriorityTokenInsertion() {
        this.head = null;
        this.size = 0;
    }

    public Node getHead() {
        return head;
    }

    public int getSize() {
        return size;
    }

    /**
     * Adds a token at the front (priority).
     * Time Complexity: O(1)
     */
    public void addFirst(int token) {
        Node newNode = new Node(token);
        newNode.next = head;
        head = newNode;
        size++;
    }

    /**
     * Adds a token at the end (normal).
     * Time Complexity: O(n)
     */
    public void addLast(int token) {
        Node newNode = new Node(token);
        if (head == null) {
            head = newNode;
        } else {
            Node curr = head;
            while (curr.next != null) {
                curr = curr.next;
            }
            curr.next = newNode;
        }
        size++;
    }

    /**
     * Inserts a token at a given 0-based position (rescheduled).
     * Time Complexity: O(n)
     */
    public void insertAt(int index, int token) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        if (index == 0) {
            addFirst(token);
            return;
        }

        Node newNode = new Node(token);
        Node prev = head;
        for (int i = 0; i < index - 1; i++) {
            prev = prev.next;
        }

        newNode.next = prev.next;
        prev.next = newNode;
        size++;
    }

    public String printList() {
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
