package Stack.Basics;
import java.util.*;

public class nextGreaterElement {
    public static void main(String[] args) {
        int arr[] = { 1, 8, 3, 4, 2, 6 };
        Stack<Integer> s = new Stack<>();
        int nextGreater[] = new int[arr.length];
        for (int i = arr.length - 1; i >= 0; i--) {//in case i want to find nexr greater left the we start from 0 to n-1 and i++
            // 1 while
            while (!s.isEmpty() && arr[s.peek()] <= arr[i]) {//if i want nextsmallest then s.peek()] >= arr[i]
                                                             //if bola gya next smaller left to for loop ko 0 to n-1 krna h aur s.peek()] >= arr[i]
                s.pop();
            }
            // 2 if-else
            if (s.isEmpty()) {
                nextGreater[i] = -1;
            } else {
                nextGreater[i] = arr[s.peek()];
            }
            // 3 push in stack
            s.push(i);
        }
        for(int i=0;i<nextGreater.length; i++){
            System.out.print(nextGreater[i]+" ");
        }
    }
}