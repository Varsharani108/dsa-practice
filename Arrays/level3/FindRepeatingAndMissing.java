package Arrays.level3;

import java.util.HashMap;

public class FindRepeatingAndMissing {

    public static void findMissingAndRepeating(int[] arr) {

        int n = arr.length;

        HashMap<Integer, Integer> map = new HashMap<>();

        // Count frequency
        for (int num : arr) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        int repeating = -1;
        int missing = -1;

        // Find repeating and missing
        for (int i = 1; i <= n; i++) {

            if (map.getOrDefault(i, 0) == 2) {
                repeating = i;
            }

            if (map.getOrDefault(i, 0) == 0) {
                missing = i;
            }
        }

        System.out.println("Repeating = " + repeating);
        System.out.println("Missing = " + missing);
    }

    public static void main(String[] args) {

        int[] arr = {4, 3, 6, 2, 1, 1};

        findMissingAndRepeating(arr);
    }
}