package Recursion.medium;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {

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

        // TAKE
        current.add(arr[index]);

        findCombinations(
                arr,
                index,
                remaining - arr[index],
                current
        );

        // Backtrack
        current.remove(current.size() - 1);

        // NOT TAKE
        findCombinations(
                arr,
                index + 1,
                remaining,
                current
        );
    }

    public static void main(String[] args) {

        int[] arr = {2, 3, 6, 7};
        int target = 7;

        findCombinations(
                arr,
                0,
                target,
                new ArrayList<>()
        );
    }
}