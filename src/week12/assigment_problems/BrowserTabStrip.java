package week12.assigment_problems;

public class BrowserTabStrip {

    public static class TabNode {
        public String name;
        public TabNode prev;
        public TabNode next;

        public TabNode(String name) {
            this.name = name;
            this.prev = null;
            this.next = null;
        }
    }

    private TabNode head;
    private TabNode current;

    public BrowserTabStrip() {
        this.head = null;
        this.current = null;
    }

    /**
     * Opens a new tab right after the current tab and makes it current.
     *
     * Time Complexity of open(): O(1) for pointer updates, O(n) to format/print the tab strip.
     */
    public String open(String name) {
        TabNode newTab = new TabNode(name);
        if (current == null) {
            head = newTab;
            current = newTab;
        } else {
            newTab.prev = current;
            newTab.next = current.next;
            if (current.next != null) {
                current.next.prev = newTab;
            }
            current.next = newTab;
            current = newTab;
        }
        String out = "OPEN " + name + ": " + formatStrip();
        System.out.println(out);
        return out;
    }

    /**
     * Closes the current tab; the next tab becomes current, or the previous one if there is no next tab.
     *
     * Time Complexity of close(): O(1) for pointer updates, O(n) to format/print the tab strip.
     */
    public String close() {
        if (current == null) {
            String out = "CLOSE: (no open tabs)";
            System.out.println(out);
            return out;
        }

        String closedName = current.name;
        TabNode prevTab = current.prev;
        TabNode nextTab = current.next;

        if (prevTab != null) {
            prevTab.next = nextTab;
        } else {
            head = nextTab;
        }

        if (nextTab != null) {
            nextTab.prev = prevTab;
        }

        current = (nextTab != null) ? nextTab : prevTab;

        String out = "CLOSE " + closedName + ": " + formatStrip();
        System.out.println(out);
        return out;
    }

    /**
     * Moves current to the previous tab, or reports "already at first tab".
     *
     * Time Complexity of back(): O(1) for pointer update, O(n) to format/print the tab strip.
     */
    public String back() {
        if (current == null || current.prev == null) {
            String out = "BACK: already at first tab";
            System.out.println(out);
            return out;
        }
        current = current.prev;
        String out = "BACK: " + formatStrip();
        System.out.println(out);
        return out;
    }

    /**
     * Moves current to the next tab, or reports "already at last tab".
     *
     * Time Complexity of forward(): O(1) for pointer update, O(n) to format/print the tab strip.
     */
    public String forward() {
        if (current == null || current.next == null) {
            String out = "FORWARD: already at last tab";
            System.out.println(out);
            return out;
        }
        current = current.next;
        String out = "FORWARD: " + formatStrip();
        System.out.println(out);
        return out;
    }

    /**
     * Prints the tab strip from the last tab to the first.
     *
     * Time Complexity of printBackward(): O(n)
     */
    public String printBackward() {
        if (head == null) {
            String out = "Backward: (empty)";
            System.out.println(out);
            return out;
        }

        TabNode tail = head;
        while (tail.next != null) {
            tail = tail.next;
        }

        StringBuilder sb = new StringBuilder("Backward: ");
        TabNode curr = tail;
        while (curr != null) {
            if (curr != tail) {
                sb.append(" <-> ");
            }
            sb.append(curr.name);
            curr = curr.prev;
        }

        String out = sb.toString();
        System.out.println(out);
        return out;
    }

    public String formatStrip() {
        if (head == null) {
            return "(empty)";
        }
        StringBuilder sb = new StringBuilder();
        TabNode curr = head;
        while (curr != null) {
            if (curr != head) {
                sb.append(" <-> ");
            }
            if (curr == current) {
                sb.append("[").append(curr.name).append("]");
            } else {
                sb.append(curr.name);
            }
            curr = curr.next;
        }
        return sb.toString();
    }
}
