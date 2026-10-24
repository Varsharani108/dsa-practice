package Heap.Basics;

import java.util.ArrayList;

public class Heapify {

    // Convert array into Max Heap
    public static void heapify(ArrayList<Integer> arr, int i, int size) {

        int largest = i;

        int left = 2 * i + 1;
        int right = 2 * i + 2;

        // Check if left child is greater
        if (left < size && arr.get(left) > arr.get(largest)) {
            largest = left;
        }

        // Check if right child is greater
        if (right < size && arr.get(right) > arr.get(largest)) {
            largest = right;
        }

        // If parent is not the largest, swap
        if (largest != i) {
            int temp = arr.get(i);
            arr.set(i, arr.get(largest));
            arr.set(largest, temp);

            // Heapify the affected subtree
            heapify(arr, largest, size);
        }
    }

    // Build Max Heap from an array
    public static void buildMaxHeap(ArrayList<Integer> arr) {

        int n = arr.size();

        // Start from the last non-leaf node
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(arr, i, n);
        }
    }

    public static void main(String[] args) {

        ArrayList<Integer> arr = new ArrayList<>();

        arr.add(10);
        arr.add(20);
        arr.add(15);
        arr.add(30);
        arr.add(40);

        System.out.println("Original Array: " + arr);

        buildMaxHeap(arr);

        System.out.println("Max Heap: " + arr);
    }
}