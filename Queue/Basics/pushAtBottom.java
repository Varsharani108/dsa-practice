package Queue.Basics;

import java.util.*;

public class pushAtBottom {

    public static void pushatbottom(Stack<Integer> s, int data) {
        if (s.isEmpty()) {
            s.push(data);
            return;
        }

        int top = s.pop();
        pushatbottom(s, data);
        s.push(top);
    }

    public static void main(String[] args) {
        Stack<Integer> s = new Stack<>();

        s.push(3);
        s.push(6);
        s.push(2);
        s.push(8);

        pushatbottom(s, 4);

        while (!s.isEmpty()) {
            System.out.println(s.pop());
        }
    }
}