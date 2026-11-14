package week11.class_problems;

public class CountNodesSinglyLinkedList {

    public static class Node {
        public int data;
        public Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    /**
     * Returns the total number of nodes present in a singly linked list.
     * Returns 0 for an empty list.
     * Time Complexity: O(n)
     * Extra Space Complexity: O(1)
     */
    public static int countNodes(Node head) {
        int count = 0;
        Node current = head;
        while (current != null) {
            count++;
            current = current.next;
        }
        return count;
    }
}
