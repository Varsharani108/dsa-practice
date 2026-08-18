package Arrays.level3;

import java.util.HashSet;

public class LongestConsecutiveSequence {

    public static int longestConsecutive(int[] arr) {

        if (arr.length == 0) {
            return 0;
        }

        HashSet<Integer> set = new HashSet<>();

        // Store all elements in HashSet
        for (int num : arr) {
            set.add(num);
        }

        int longest = 1;

        // Find longest sequence
        for (int num : set) {

            // Start only if previous number is not present
            if (!set.contains(num - 1)) {

                int currentNum = num;
                int count = 1;

                while (set.contains(currentNum + 1)) {
                    currentNum++;
                    count++;
                }

                longest = Math.max(longest, count);
            }
        }

        return longest;
    }

    public static void main(String[] args) {

        int[] arr = {100, 4, 200, 1, 3, 2};

        System.out.println(longestConsecutive(arr));
    }
}