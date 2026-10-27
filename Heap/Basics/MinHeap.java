package Heap.Basics;

import java.util.ArrayList;

public class MinHeap {

    private ArrayList<Integer> arr = new ArrayList<>();

    // Insert element into Min Heap
    public void add(int data) {
        arr.add(data);

        int child = arr.size() - 1;

        // Heapify Up
        while (child > 0) {
            int parent = (child - 1) / 2;

            if (arr.get(parent) <= arr.get(child)) {
                break;
            }

            swap(child, parent);
            child = parent;
        }
    }

    // Return minimum element
    public int peek() {
        if (arr.isEmpty()) {
            throw new IllegalStateException("Heap is empty");
        }

        return arr.get(0);
    }

    // Remove minimum element
    public int remove() {
        if (arr.isEmpty()) {
            throw new IllegalStateException("Heap is empty");
        }

        int min = arr.get(0);
        int lastIndex = arr.size() - 1;

        swap(0, lastIndex);
        arr.remove(lastIndex);

        if (!arr.isEmpty()) {
            heapify(0);
        }

        return min;
    }

    // Restore Min Heap property
    private void heapify(int i) {
        int smallest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        if (left < arr.size()
                && arr.get(left) < arr.get(smallest)) {
            smallest = left;
        }

        if (right < arr.size()
                && arr.get(right) < arr.get(smallest)) {
            smallest = right;
        }

        if (smallest != i) {
            swap(i, smallest);
            heapify(smallest);
        }
    }

    // Swap two elements
    private void swap(int i, int j) {
        int temp = arr.get(i);
        arr.set(i, arr.get(j));
        arr.set(j, temp);
    }

    // Check if heap is empty
    public boolean isEmpty() {
        return arr.isEmpty();
    }

    // Print heap
    public void printHeap() {
        System.out.println(arr);
    }

    public static void main(String[] args) {
        MinHeap heap = new MinHeap();

        heap.add(40);
        heap.add(20);
        heap.add(30);
        heap.add(10);
        heap.add(15);

        System.out.print("Min Heap: ");
        heap.printHeap();

        System.out.println("Minimum Element: " + heap.peek());

        System.out.println("Deleted Element: " + heap.remove());

        System.out.print("After Deletion: ");
        heap.printHeap();

        System.out.println("New Minimum: " + heap.peek());
    }
}