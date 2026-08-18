package Arrays.level3;

import java.util.HashMap;

public class CountSubarraysWithGivenSum {

    public static int countSubarrays(int[] arr, int k) {

        HashMap<Integer, Integer> map = new HashMap<>();

        map.put(0, 1);

        int prefixSum = 0;
        int count = 0;

        for (int i = 0; i < arr.length; i++) {

            prefixSum += arr[i];

            if (map.containsKey(prefixSum - k)) {
                count += map.get(prefixSum - k);
            }

            map.put(prefixSum, map.getOrDefault(prefixSum, 0) + 1);
        }

        return count;
    }

    public static void main(String[] args) {

        int[] arr = {1, 2, 3};

        int k = 3;

        System.out.println(countSubarrays(arr, k));
    }
}