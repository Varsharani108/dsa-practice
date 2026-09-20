package basics;

public class addLast {

    // Node
    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    // Add at Last
    public static Node addLast(Node head, int data) {

        Node newNode = new Node(data);

        // If Linked List is empty
        if (head == null) {
            return newNode;
        }

        Node temp = head;

        // Go to last node
        while (temp.next != null) {
            temp = temp.next;
        }

        // Add new node at last
        temp.next = newNode;

        return head;
    }

    // Print Linked List
    public static void printList(Node head) {

        Node temp = head;

        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }

        System.out.println("null");
    }

    public static void main(String[] args) {

        Node head = new Node(10);
        head.next = new Node(20);
        head.next.next = new Node(30);

        System.out.println("Before adding:");
        printList(head);

        head = addLast(head, 40);

        System.out.println("After adding:");
        printList(head);
    }
}