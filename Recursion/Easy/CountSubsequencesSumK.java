package Recursion.Easy;

public class CountSubsequencesSumK {

    public static int countSubsequences(int[] arr, int index, int sum, int k) {

        // Base case
        if (index == arr.length) {
            if (sum == k) {
                return 1;
            }
            return 0;
        }

        // Take the current element
        int take = countSubsequences(
                arr,
                index + 1,
                sum + arr[index],
                k
        );

        // Not take the current element
        int notTake = countSubsequences(
                arr,
                index + 1,
                sum,
                k
        );

        return take + notTake;
    }

    public static void main(String[] args) {

        int[] arr = {1, 2, 1};
        int k = 2;

        int result = countSubsequences(arr, 0, 0, k);

        System.out.println(result);
    }
}