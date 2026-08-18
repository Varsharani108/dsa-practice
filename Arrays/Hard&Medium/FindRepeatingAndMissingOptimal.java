package Arrays.level3;

public class FindRepeatingAndMissingOptimal {

    public static void findMissingAndRepeating(int[] arr) {

        int n = arr.length;

        // Step 1: Find XOR of array and numbers from 1 to n
        int xor = 0;

        for (int i = 0; i < n; i++) {
            xor = xor ^ arr[i];
        }

        for (int i = 1; i <= n; i++) {
            xor = xor ^ i;
        }

        // Step 2: Find rightmost set bit
        int bit = xor & -xor;

        int group1 = 0;
        int group2 = 0;

        // Step 3: Divide array elements into two groups
        for (int num : arr) {

            if ((num & bit) != 0) {
                group1 = group1 ^ num;
            }
            else {
                group2 = group2 ^ num;
            }
        }

        // Step 4: Divide numbers 1 to n into two groups
        for (int i = 1; i <= n; i++) {

            if ((i & bit) != 0) {
                group1 = group1 ^ i;
            }
            else {
                group2 = group2 ^ i;
            }
        }

        // Step 5: Find which one is repeating
        int repeating = -1;
        int missing = -1;

        for (int num : arr) {

            if (num == group1) {
                repeating = group1;
                break;
            }

            if (num == group2) {
                repeating = group2;
                break;
            }
        }

        if (repeating == group1) {
            missing = group2;
        }
        else {
            missing = group1;
        }

        System.out.println("Repeating = " + repeating);
        System.out.println("Missing = " + missing);
    }

    public static void main(String[] args) {

        int[] arr = {4, 3, 6, 2, 1, 1};

        findMissingAndRepeating(arr);
    }
}