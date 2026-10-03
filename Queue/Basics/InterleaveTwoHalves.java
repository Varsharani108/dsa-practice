package Queue.Basics;

import java.util.*;

public class InterleaveTwoHalves {

    public static void interleave(Queue<Integer> q) {

        int n = q.size();

        // First half ko separate queue me store karo
        Queue<Integer> firstHalf = new LinkedList<>();

        for (int i = 0; i < n / 2; i++) {
            firstHalf.add(q.remove());
        }

        // First half aur second half ko alternate add karo
        while (!firstHalf.isEmpty()) {
            q.add(firstHalf.remove());
            q.add(q.remove());
        }
    }

    public static void main(String[] args) {

        Queue<Integer> q = new LinkedList<>();

        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);
        q.add(5);
        q.add(6);

        System.out.println("Original Queue: " + q);

        interleave(q);

        System.out.println("After Interleaving: " + q);
    }
}