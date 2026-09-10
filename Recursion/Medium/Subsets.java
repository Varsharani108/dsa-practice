package Recursion.medium;

import java.util.ArrayList;
import java.util.List;

public class Subsets {

    public static void generate(
            int[] arr,
            int index,
            List<Integer> current) {

        // Base case
        if (index == arr.length) {
            System.out.println(current);
            return;
        }

        // TAKE
        current.add(arr[index]);

        generate(arr, index + 1, current);

        // BACKTRACK
        current.remove(current.size() - 1);

        // NOT TAKE
        generate(arr, index + 1, current);
    }

    public static void main(String[] args) {

        int[] arr = {1, 2, 3};

        generate(arr, 0, new ArrayList<>());
    }
}