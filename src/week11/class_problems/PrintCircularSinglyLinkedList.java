package week11.class_problems;

public class PrintCircularSinglyLinkedList {

    public static class Node {
        public int data;
        public Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    /**
     * Prints the data of each node in a circular singly linked list exactly once,
     * separated by a space, followed by a newline.
     * Handles an empty list by printing only a newline.
     * Time Complexity: O(n)
     * Extra Space Complexity: O(1)
     */
    public static void printCircular(Node head) {
        if (head == null) {
            System.out.println();
            return;
        }

        Node current = head;
        StringBuilder sb = new StringBuilder();
        do {
            if (sb.length() > 0) {
                sb.append(" ");
            }
            sb.append(current.data);
            current = current.next;
        } while (current != head);

        System.out.println(sb.toString());
    }
}
