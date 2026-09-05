package Recursion.medium;

import java.util.Stack;

public class SortStack {

    // Stack mein element ko correct position par insert karega
    public static void insertSorted(Stack<Integer> stack, int value) {

        if (stack.isEmpty() || stack.peek() <= value) {
            stack.push(value);
            return;
        }

        int top = stack.pop();

        insertSorted(stack, value);

        stack.push(top);
    }

    // Stack ko recursively sort karega
    public static void sortStack(Stack<Integer> stack) {

        if (stack.isEmpty()) {
            return;
        }

        int top = stack.pop();

        sortStack(stack);

        insertSorted(stack, top);
    }

    public static void main(String[] args) {

        Stack<Integer> stack = new Stack<>();

        stack.push(3);
        stack.push(1);
        stack.push(4);
        stack.push(2);

        sortStack(stack);

        System.out.println(stack);
    }
}