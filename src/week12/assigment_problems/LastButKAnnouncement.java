package week12.assigment_problems;

public class LastButKAnnouncement {

    public static class Node {
        public int data;
        public Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    /**
     * Finds the k-th announcement from the end in a single pass using lead and trail pointers.
     * If k <= 0 or k is larger than the number of announcements, returns "Invalid k".
     *
     * Time Complexity: O(n) single pass
     * Additional Space Complexity: O(1)
     * Comparison with two-pass solution:
     * A two-pass solution first traverses all n nodes to count the length L, then traverses
     * (L - k) nodes in a second pass (total 2n - k node visits). The single-pass lead/trail
     * pointer method advances 'lead' k steps first and then moves both pointers in lockstep
     * until 'lead' reaches null, requiring only one scan of the list with better cache locality.
     */
    public static String kthFromEnd(Node head, int k) {
        if (head == null || k <= 0) {
            return "Invalid k";
        }

        Node lead = head;
        for (int i = 0; i < k; i++) {
            if (lead == null) {
                return "Invalid k";
            }
            lead = lead.next;
        }

        Node trail = head;
        while (lead != null) {
            lead = lead.next;
            trail = trail.next;
        }

        return k + " from the end: " + trail.data;
    }
}
