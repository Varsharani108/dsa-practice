package Heap.Basics;

import java.util.ArrayList;

public class DeleteFromHeap {

    static class MaxHeap {
        ArrayList<Integer> arr = new ArrayList<>();

        // Insert element
        public void add(int data) {
            arr.add(data);

            int child = arr.size() - 1;

            while (child > 0) {
                int parent = (child - 1) / 2;

                if (arr.get(child) <= arr.get(parent)) {
                    break;
                }

                swap(child, parent);
                child = parent;
            }
        }

        // Delete maximum element (root)
        public int remove() {
            if (arr.isEmpty()) {
                throw new IllegalStateException("Heap is empty");
            }

            int max = arr.get(0);
            int lastIndex = arr.size() - 1;

            // Move last element to root
            swap(0, lastIndex);

            // Remove last element
            arr.remove(lastIndex);

            // Restore Max Heap property
            if (!arr.isEmpty()) {
                heapify(0);
            }

            return max;
        }

        // Heapify Down
        private void heapify(int i) {
            int largest = i;
            int left = 2 * i + 1;
            int right = 2 * i + 2;

            if (left < arr.size()
                    && arr.get(left) > arr.get(largest)) {
                largest = left;
            }

            if (right < arr.size()
                    && arr.get(right) > arr.get(largest)) {
                largest = right;
            }

            if (largest != i) {
                swap(i, largest);
                heapify(largest);
            }
        }

        // Swap two elements
        private void swap(int i, int j) {
            int temp = arr.get(i);
            arr.set(i, arr.get(j));
            arr.set(j, temp);
        }

        public int peek() {
            if (arr.isEmpty()) {
                throw new IllegalStateException("Heap is empty");
            }
            return arr.get(0);
        }

        public void printHeap() {
            System.out.println(arr);
        }
    }

    public static void main(String[] args) {
        MaxHeap heap = new MaxHeap();

        heap.add(10);
        heap.add(20);
        heap.add(15);
        heap.add(30);
        heap.add(40);

        System.out.print("Original Max Heap: ");
        heap.printHeap();

        System.out.println("Deleted Element: " + heap.remove());

        System.out.print("Heap After Deletion: ");
        heap.printHeap();

        System.out.println("New Maximum: " + heap.peek());
    }
}
