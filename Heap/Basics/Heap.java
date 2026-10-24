package Heap.Basics;

import java.util.ArrayList;

public class Heap {

    static class MaxHeap {
        ArrayList<Integer> arr = new ArrayList<>();

        // Insert a new element into Max Heap
        public void add(int data) {
            // Add element at the end
            arr.add(data);

            int child = arr.size() - 1;
            int parent = (child - 1) / 2;

            // Heapify Up
            while (child > 0 && arr.get(child) > arr.get(parent)) {

                // Swap child and parent
                int temp = arr.get(child);
                arr.set(child, arr.get(parent));
                arr.set(parent, temp);

                // Update indexes
                child = parent;
                parent = (child - 1) / 2;
            }
        }

        // Return the maximum element
        public int peek() {
            if (arr.isEmpty()) {
                throw new IllegalStateException("Heap is empty");
            }

            return arr.get(0);
        }

        // Display heap elements
        public void printHeap() {
            System.out.println(arr);
        }

        // Check whether heap is empty
        public boolean isEmpty() {
            return arr.isEmpty();
        }

        // Return number of elements
        public int size() {
            return arr.size();
        }
    }

    public static void main(String[] args) {
        MaxHeap heap = new MaxHeap();

        heap.add(10);
        heap.add(20);
        heap.add(15);
        heap.add(30);
        heap.add(40);

        System.out.print("Max Heap: ");
        heap.printHeap();

        System.out.println("Maximum Element: " + heap.peek());
        System.out.println("Heap Size: " + heap.size());
        System.out.println("Is Heap Empty? " + heap.isEmpty());
    }
}