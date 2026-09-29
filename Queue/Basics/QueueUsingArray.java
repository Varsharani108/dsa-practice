package Queue.Basics;

public class QueueUsingArray {

    static class Queue {

        int arr[];
        int size;
        int rear;

        Queue(int n) {
            arr = new int[n];
            size = n;
            rear = -1;
        }

        // Add
        public void add(int data) {

            if (rear == size - 1) {
                System.out.println("Queue is full");
                return;
            }

            rear++;
            arr[rear] = data;
        }

        // Remove
        public int remove() {

            if (rear == -1) {
                System.out.println("Queue is empty");
                return -1;
            }

            int front = arr[0];

            // Shift elements
            for (int i = 0; i < rear; i++) {
                arr[i] = arr[i + 1];
            }

            rear--;

            return front;
        }

        // Peek
        public int peek() {

            if (rear == -1) {
                System.out.println("Queue is empty");
                return -1;
            }

            return arr[0];
        }

        // isEmpty
        public boolean isEmpty() {
            return rear == -1;
        }
    }

    public static void main(String[] args) {

        Queue q = new Queue(5);

        q.add(1);
        q.add(2);
        q.add(3);

        System.out.println(q.remove());
        System.out.println(q.peek());
        System.out.println(q.isEmpty());
    }
}