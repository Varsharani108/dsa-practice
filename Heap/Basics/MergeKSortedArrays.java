package Heap.Basics;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class MergeKSortedArrays {

    static class Node implements Comparable<Node> {
        int value;
        int arrayIndex;
        int elementIndex;

        Node(int value, int arrayIndex, int elementIndex) {
            this.value = value;
            this.arrayIndex = arrayIndex;
            this.elementIndex = elementIndex;
        }

        // Compare nodes according to value
        @Override
        public int compareTo(Node other) {
            return Integer.compare(this.value, other.value);
        }
    }

    public static ArrayList<Integer> mergeKArrays(int[][] arrays) {

        ArrayList<Integer> result = new ArrayList<>();

        // Min Heap
        PriorityQueue<Node> pq = new PriorityQueue<>();

        // Add first element of every array
        for (int i = 0; i < arrays.length; i++) {

            if (arrays[i].length > 0) {
                pq.add(new Node(arrays[i][0], i, 0));
            }
        }

        // Process smallest element
        while (!pq.isEmpty()) {

            Node current = pq.remove();

            result.add(current.value);

            int nextIndex = current.elementIndex + 1;
            int arrayIndex = current.arrayIndex;

            // Add next element from the same array
            if (nextIndex < arrays[arrayIndex].length) {

                pq.add(new Node(
                        arrays[arrayIndex][nextIndex],
                        arrayIndex,
                        nextIndex
                ));
            }
        }

        return result;
    }

    public static void main(String[] args) {

        int[][] arrays = {
                {1, 4, 7},
                {2, 5, 8},
                {3, 6, 9}
        };

        ArrayList<Integer> result = mergeKArrays(arrays);

        System.out.println("Merged Sorted Array: " + result);
    }
}