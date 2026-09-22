package basics;

public class CheckLLPalindrome {

    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    Node head;

    public Node findMid(Node head) {

        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    public boolean checkPalindrome() {

        if (head == null || head.next == null) {
            return true;
        }

        // Step 1: Find mid
        Node midNode = findMid(head);

        // Step 2: Reverse 2nd half
        Node prev = null;
        Node curr = midNode;

        while (curr != null) {
            Node next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        Node right = prev;   // right half head
        Node left = head;    // left half head

        // Step 3: Check left half and right half
        while (right != null) {

            if (left.data != right.data) {
                return false;
            }

            left = left.next;
            right = right.next;
        }

        return true;
    }

    public static void main(String[] args) {

        CheckLLPalindrome ll = new CheckLLPalindrome();

        ll.head = new Node(1);
        ll.head.next = new Node(2);
        ll.head.next.next = new Node(2);
        ll.head.next.next.next = new Node(1);

        System.out.println(ll.checkPalindrome());
    }
}