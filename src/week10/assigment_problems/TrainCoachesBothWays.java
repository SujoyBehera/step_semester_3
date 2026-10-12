package week10.assigment_problems;

public class TrainCoachesBothWays {

    public static class Node {
        public String name;
        public Node prev;
        public Node next;

        public Node(String name) {
            this.name = name;
            this.prev = null;
            this.next = null;
        }
    }

    private Node head;
    private Node tail;

    public TrainCoachesBothWays() {
        this.head = null;
        this.tail = null;
    }

    public Node getHead() {
        return head;
    }

    public Node getTail() {
        return tail;
    }

    /**
     * Appends a coach to the train (tail).
     * Time Complexity: O(1)
     */
    public void addLast(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Coach name cannot be blank");
        }
        Node newNode = new Node(name);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
    }

    /**
     * Removes the first coach with the given name.
     * Time Complexity: O(n) to find the coach, O(1) to unlink once found.
     */
    public boolean remove(String name) {
        if (name == null || head == null) {
            return false;
        }

        Node curr = head;
        while (curr != null) {
            if (curr.name.equals(name)) {
                // If node is head
                if (curr == head) {
                    head = head.next;
                    if (head != null) {
                        head.prev = null;
                    } else {
                        tail = null;
                    }
                } else if (curr == tail) { // If node is tail
                    tail = tail.prev;
                    if (tail != null) {
                        tail.next = null;
                    } else {
                        head = null;
                    }
                } else { // Middle node
                    curr.prev.next = curr.next;
                    curr.next.prev = curr.prev;
                }
                return true;
            }
            curr = curr.next;
        }

        return false;
    }

    public String printForward() {
        StringBuilder sb = new StringBuilder();
        sb.append("Forward: ");
        Node curr = head;
        while (curr != null) {
            sb.append(curr.name);
            if (curr.next != null) {
                sb.append(" <-> ");
            }
            curr = curr.next;
        }
        return sb.toString();
    }

    public String printBackward() {
        StringBuilder sb = new StringBuilder();
        sb.append("Backward: ");
        Node curr = tail;
        while (curr != null) {
            sb.append(curr.name);
            if (curr.prev != null) {
                sb.append(" <-> ");
            }
            curr = curr.prev;
        }
        return sb.toString();
    }
}
