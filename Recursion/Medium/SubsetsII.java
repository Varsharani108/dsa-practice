package Recursion.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubsetsII {

    public static void generate(
            int[] arr,
            int index,
            List<Integer> current) {

        // Base case
        if (index == arr.length) {
            System.out.println(current);
            return;
        }

        for (int i = index; i < arr.length; i++) {

            // Skip duplicate at the same level
            if (i > index && arr[i] == arr[i - 1]) {
                continue;
            }

            // Choose
            current.add(arr[i]);

            // Recursion
            generate(arr, i + 1, current);

            // Backtrack
            current.remove(current.size() - 1);
        }
    }

    public static void main(String[] args) {

        int[] arr = {1, 2, 2};

        Arrays.sort(arr);

        generate(arr, 0, new ArrayList<>());
    }
}