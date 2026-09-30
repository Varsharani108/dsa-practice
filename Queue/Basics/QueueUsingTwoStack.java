package Queue.Basics;
import java.util.*;

public class QueueUsingTwoStack {

    Stack<Integer> s1 = new Stack<>();
    Stack<Integer> s2 = new Stack<>();

    // Add
    public void add(int data) {

        // s1 ke saare elements s2 mein
        while (!s1.isEmpty()) {
            s2.push(s1.pop());
        }

        // new element add
        s1.push(data);

        // s2 ke elements wapas s1 mein
        while (!s2.isEmpty()) {
            s1.push(s2.pop());
        }
    }

    // Remove
    public int remove() {

        if (s1.isEmpty()) {
            System.out.println("Queue is empty");
            return -1;
        }

        return s1.pop();
    }

    // Peek
    public int peek() {

        if (s1.isEmpty()) {
            System.out.println("Queue is empty");
            return -1;
        }

        return s1.peek();
    }

    public boolean isEmpty() {
        return s1.isEmpty();
    }

    public static void main(String[] args) {

        QueueUsingTwoStack q = new QueueUsingTwoStack();

        q.add(1);
        q.add(2);
        q.add(3);

        System.out.println(q.remove()); // 1
        System.out.println(q.remove()); // 2

        q.add(4);

        System.out.println(q.peek());   // 3
        System.out.println(q.remove()); // 3
        System.out.println(q.remove()); // 4
    }
}