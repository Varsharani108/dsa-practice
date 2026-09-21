package DynamicProgramming.DP_on_subsequenses;

public class PartitionEqualSubsetSum {

    public static boolean canPartition(int arr[]) {

        int totalSum = 0;

        for (int num : arr) {
            totalSum += num;
        }

        if (totalSum % 2 != 0) {
            return false;
        }

        int target = totalSum / 2;

        boolean dp[] = new boolean[target + 1];

        dp[0] = true;

        for (int num : arr) {
            for (int sum = target; sum >= num; sum--) {

                dp[sum] = dp[sum] || dp[sum - num];
            }
        }

        return dp[target];
    }
    public static void main(String[]args){
        int arr[] = {1, 5, 11, 5};
        System.out.println(canPartition(arr));
    }
}