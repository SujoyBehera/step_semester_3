package week10.assigment_problems;

public class RoundRobinGameTurns {

    public static class Node {
        public String name;
        public Node next;

        public Node(String name) {
            this.name = name;
            this.next = null;
        }
    }

    private Node tail;
    private int size;

    public RoundRobinGameTurns() {
        this.tail = null;
        this.size = 0;
    }

    public Node getTail() {
        return tail;
    }

    public int getSize() {
        return size;
    }

    /**
     * Appends a player to the circular singly linked list.
     * Maintains a tail reference where tail.next is the head.
     * Time Complexity: O(1)
     */
    public void addLast(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Player name cannot be blank");
        }
        Node newNode = new Node(name);
        if (tail == null) {
            tail = newNode;
            tail.next = tail;
        } else {
            newNode.next = tail.next;
            tail.next = newNode;
            tail = newNode;
        }
        size++;
    }

    /**
     * Traverses the circular list from the head (tail.next) and returns who plays each turn.
     * Time Complexity: O(turns)
     */
    public String printTurns(int turns) {
        if (tail == null || turns <= 0) {
            return "";
        }

        StringBuilder sb = new StringBuilder();
        Node curr = tail.next; // Head of circular list

        for (int i = 0; i < turns; i++) {
            sb.append(curr.name);
            if (i < turns - 1) {
                sb.append(" ");
            }
            curr = curr.next;
        }

        return sb.toString();
    }
}
