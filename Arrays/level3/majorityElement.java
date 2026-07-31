package Arrays.level3;

import java.util.HashMap;

public class majorityElement {

    public static int MajorityElement(int[] arr) {

        HashMap<Integer, Integer> map = new HashMap<>();

        // Count frequency of each element
        for (int num : arr) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        // Find majority element
        for (int key : map.keySet()) {
            if (map.get(key) > arr.length / 2) {
                return key;
            }
        }

        return -1;
    }

    public static void main(String[] args) {

        int[] arr = {2, 2, 1, 1, 1, 2, 2};

        System.out.println(MajorityElement(arr));
    }
}