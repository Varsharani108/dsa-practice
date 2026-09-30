package Queue.Basics;
import java.util.*;

public class StackUsingTwoQueue {

    Queue<Integer> q1 = new LinkedList<>();
    Queue<Integer> q2 = new LinkedList<>();

    // Push
    public void push(int data) {

        // q1 ke saare elements q2 mein
        while (!q1.isEmpty()) {
            q2.add(q1.remove());
        }

        // new element q1 mein add
        q1.add(data);

        // q2 ke saare elements wapas q1 mein
        while (!q2.isEmpty()) {
            q1.add(q2.remove());
        }
    }

    // Pop
    public int pop() {

        if (q1.isEmpty()) {
            System.out.println("Stack is empty");
            return -1;
        }

        return q1.remove();
    }

    // Peek
    public int peek() {

        if (q1.isEmpty()) {
            System.out.println("Stack is empty");
            return -1;
        }

        return q1.peek();
    }

    // Is Empty
    public boolean isEmpty() {
        return q1.isEmpty();
    }

    public static void main(String[] args) {

        StackUsingTwoQueue s = new StackUsingTwoQueue();

        s.push(1);
        s.push(2);
        s.push(3);

        System.out.println(s.pop());   // 3
        System.out.println(s.peek());  // 2
        System.out.println(s.pop());   // 2
        System.out.println(s.pop());   // 1
    }
}