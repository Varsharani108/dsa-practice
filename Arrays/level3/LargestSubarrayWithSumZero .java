package Arrays.level3;

import java.util.HashMap;

public class LargestSubarrayWithSumZero {

    public static int maxLength(int[] arr) {

        HashMap<Integer, Integer> map = new HashMap<>();

        int sum = 0;
        int maxLength = 0;

        for (int i = 0; i < arr.length; i++) {

            sum += arr[i];

            // Sum from index 0 to i is zero
            if (sum == 0) {
                maxLength = i + 1;
            }

            // Same prefix sum already exists
            if (map.containsKey(sum)) {

                int length = i - map.get(sum);

                maxLength = Math.max(maxLength, length);
            }
            else {
                // Store only first occurrence
                map.put(sum, i);
            }
        }

        return maxLength;
    }

    public static void main(String[] args) {

        int[] arr = {9, -3, 3, -1, 6, -5};

        System.out.println(maxLength(arr));
    }
}