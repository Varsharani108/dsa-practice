package Heap.Basics;

import java.util.Arrays;

public class HeapSort {

    // Maintain Max Heap property
    public static void heapify(int[] arr, int n, int i) {
        int largest = i;

        int left = 2 * i + 1;
        int right = 2 * i + 2;

        // Check left child
        if (left < n && arr[left] > arr[largest]) {
            largest = left;
        }

        // Check right child
        if (right < n && arr[right] > arr[largest]) {
            largest = right;
        }

        // Swap if root is not the largest
        if (largest != i) {
            int temp = arr[i];
            arr[i] = arr[largest];
            arr[largest] = temp;

            heapify(arr, n, largest);
        }
    }

    // Heap Sort
    public static void heapSort(int[] arr) {
        int n = arr.length;

        // Step 1: Build Max Heap
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(arr, n, i);
        }

        // Step 2: Move maximum to the end
        for (int i = n - 1; i > 0; i--) {
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            // Heapify the remaining heap
            heapify(arr, i, 0);
        }
    }

    public static void main(String[] args) {
        int[] arr = {10, 20, 15, 30, 40, 5};

        System.out.println("Original Array: " + Arrays.toString(arr));

        heapSort(arr);

        System.out.println("Sorted Array: " + Arrays.toString(arr));
    }
}