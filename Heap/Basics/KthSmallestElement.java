package Heap.Basics;

import java.util.PriorityQueue;

public class KthSmallestElement {

    public static int findKthSmallest(int[] arr, int k) {

        if (k < 1 || k > arr.length) {
            throw new IllegalArgumentException("Invalid value of k");
        }

        // Max Heap to keep the k smallest elements
        PriorityQueue<Integer> pq =
                new PriorityQueue<>((a, b) -> Integer.compare(b, a));

        for (int num : arr) {
            pq.add(num);

            // Keep only k smallest elements
            if (pq.size() > k) {
                pq.remove();
            }
        }

        // Root contains the Kth smallest element
        return pq.peek();
    }

    public static void main(String[] args) {

        int[] arr = {7, 10, 4, 3, 20, 15};
        int k = 3;

        System.out.println(
                k + "rd smallest element: " + findKthSmallest(arr, k)
        );
    }
}