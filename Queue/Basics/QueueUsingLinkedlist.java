package Queue.Basics;

public class QueueUsingLinkedlist {

    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    static class Queue {

        Node front;
        Node rear;

        // Add element
        public void add(int data) {

            Node newNode = new Node(data);

            // Queue is empty
            if (rear == null) {
                front = rear = newNode;
                return;
            }

            // Add at rear
            rear.next = newNode;
            rear = newNode;
        }

        // Remove element
        public int remove() {

            // Queue is empty
            if (front == null) {
                System.out.println("Queue is empty");
                return -1;
            }

            int result = front.data;

            // Move front
            front = front.next;

            // If queue becomes empty
            if (front == null) {
                rear = null;
            }

            return result;
        }

        // Peek
        public int peek() {

            if (front == null) {
                System.out.println("Queue is empty");
                return -1;
            }

            return front.data;
        }

        // Is Empty
        public boolean isEmpty() {
            return front == null;
        }
    }

    public static void main(String[] args) {

        Queue q = new Queue();

        q.add(1);
        q.add(2);
        q.add(3);

        System.out.println(q.remove());
        System.out.println(q.peek());
        System.out.println(q.isEmpty());
    }
}