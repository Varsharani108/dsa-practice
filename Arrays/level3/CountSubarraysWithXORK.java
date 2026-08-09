package Arrays.level3;

import java.util.HashMap;

public class CountSubarraysWithXORK {

    public static int countSubarrays(int[] arr, int k) {

        HashMap<Integer, Integer> map = new HashMap<>();

        // XOR 0 has occurred once
        map.put(0, 1);

        int xor = 0;
        int count = 0;

        for (int i = 0; i < arr.length; i++) {

            xor = xor ^ arr[i];

            int required = xor ^ k;

            if (map.containsKey(required)) {
                count += map.get(required);
            }

            map.put(xor, map.getOrDefault(xor, 0) + 1);
        }

        return count;
    }

    public static void main(String[] args) {

        int[] arr = {4, 2, 2, 6, 4};

        int k = 6;

        System.out.println(countSubarrays(arr, k));
    }
}