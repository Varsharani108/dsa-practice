package basics;

public class addFirst {

    // Node
    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    // Add at First
    public static Node addFirst(Node head, int data) {

        Node newNode = new Node(data);

        newNode.next = head;
        head = newNode;

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

        head = addFirst(head, 5);

        System.out.println("After adding:");
        printList(head);
    }
}