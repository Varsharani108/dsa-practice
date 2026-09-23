package basics;

public class zigZagMerge {

    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    static Node head;

    // Find middle
    public static Node getMid(Node head) {
        Node slow = head;
        Node fast = head.next;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    // Reverse second half
    public static Node reverse(Node head) {
        Node prev = null;
        Node curr = head;

        while (curr != null) {
            Node next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;
    }

    // ZigZag merge
    public static void zigZag() {

        // Find middle
        Node mid = getMid(head);

        // Split the list
        Node rightHead = mid.next;
        mid.next = null;

        // Reverse second half
        rightHead = reverse(rightHead);

        Node left = head;
        Node right = rightHead;

        // Alternate nodes
        while (left != null && right != null) {

            Node nextLeft = left.next;
            Node nextRight = right.next;

            left.next = right;
            right.next = nextLeft;

            left = nextLeft;
            right = nextRight;
        }
    }

    // Print linked list
    public static void printList(Node head) {
        Node temp = head;

        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }

        System.out.println("null");
    }

    public static void main(String[] args) {

        head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);

        System.out.println("Original List:");
        printList(head);

        zigZag();

        System.out.println("ZigZag List:");
        printList(head);
    }
}