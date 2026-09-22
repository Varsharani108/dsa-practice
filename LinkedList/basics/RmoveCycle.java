package basics;

public class RmoveCycle {

    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    static Node head;

    public static boolean isCycle() {

        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {

            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                return true;
            }
        }

        return false;
    }

    public static void removeCycle() {

        // Step 1: Detect cycle
        Node slow = head;
        Node fast = head;
        boolean exist = false;

        while (fast != null && fast.next != null) {

            slow = slow.next;
            fast = fast.next.next;

            if (fast == slow) {
                exist = true;
                break;
            }
        }

        // No cycle
        if (exist == false) {
            return;
        }

        // Step 2: Find meeting point
        slow = head;
        Node prev = null;

        while (slow != fast) {

            prev = fast;

            slow = slow.next;
            fast = fast.next;
        }

        // Step 3: Remove cycle
        prev.next = null;
    }

    public static void main(String[] args) {

        head = new Node(1);

        Node temp = new Node(2);
        head.next = temp;

        head.next.next = new Node(3);

        // Creating cycle
        head.next.next.next = temp;

        System.out.println(isCycle());

        removeCycle();

        System.out.println(isCycle());
    }
}