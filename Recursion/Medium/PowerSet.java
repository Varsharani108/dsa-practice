package Recursion.medium;

import java.util.ArrayList;
import java.util.List;

public class PowerSet {

    public static void generate(int[] arr, int index, List<Integer> current) {

        // Base case
        if (index == arr.length) {
            System.out.println(current);
            return;
        }

        // Take the element
        current.add(arr[index]);
        generate(arr, index + 1, current);

        // Backtrack
        current.remove(current.size() - 1);

        // Not take the element
        generate(arr, index + 1, current);
    }

    public static void main(String[] args) {

        int[] arr = {1, 2, 3};

        generate(arr, 0, new ArrayList<>());
    }
}