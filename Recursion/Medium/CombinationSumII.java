package Recursion.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSumII {

    public static void findCombinations(
            int[] arr,
            int index,
            int remaining,
            List<Integer> current) {

        // Target complete
        if (remaining == 0) {
            System.out.println(current);
            return;
        }

        // Elements khatam
        if (index == arr.length || remaining < 0) {
            return;
        }

        for (int i = index; i < arr.length; i++) {

            // Same level par duplicate skip
            if (i > index && arr[i] == arr[i - 1]) {
                continue;
            }

            // Current element ko take
            current.add(arr[i]);

            // Element sirf ek baar use hoga
            findCombinations(
                    arr,
                    i + 1,
                    remaining - arr[i],
                    current
            );

            // Backtrack
            current.remove(current.size() - 1);
        }
    }

    public static void main(String[] args) {

        int[] arr = {10, 1, 2, 7, 6, 1, 5};
        int target = 8;

        Arrays.sort(arr);

        findCombinations(
                arr,
                0,
                target,
                new ArrayList<>()
        );
    }
}