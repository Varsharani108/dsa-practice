package basics;

public class doublyLinkedList {

    static class Node {
        int data;
        Node prev;
        Node next;

        Node(int data) {
            this.data = data;
            this.prev = null;
            this.next = null;
        }
    }

    static Node head;
    static Node tail;

    // Add node at first
    public static void addFirst(int data) {

        Node newNode = new Node(data);

        // If list is empty
        if (head == null) {
            head = tail = newNode;
            return;
        }

        // Connect new node with current head
        newNode.next = head;
        head.prev = newNode;

        // Make new node head
        head = newNode;
    }

    // Remove last node
    public static void removeLast() {

        // If list is empty
        if (head == null) {
            System.out.println("Linked List is empty");
            return;
        }

        // If only one node
        if (head == tail) {
            head = tail = null;
            return;
        }

        // Move tail to previous node
        tail = tail.prev;

        // Remove connection with old last node
        tail.next = null;
    }

    // Print linked list
    public static void print() {

        Node temp = head;

        while (temp != null) {
            System.out.print(temp.data + " <-> ");
            temp = temp.next;
        }

        System.out.println("null");
    }

    public static void main(String[] args) {

        addFirst(3);
        addFirst(2);
        addFirst(1);

        System.out.println("Doubly Linked List:");
        print();

        removeLast();

        System.out.println("After removeLast:");
        print();
    }
}