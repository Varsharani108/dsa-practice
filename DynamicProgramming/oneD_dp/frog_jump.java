package DynamicProgramming.oneD_dp;

import java.util.Arrays;

public class frog_jump {

    static int frogJump(int index, int[] height, int[] dp) {

        // Base case
        if (index == 0) {
            return 0;
        }

        // Already calculated
        if (dp[index] != -1) {
            return dp[index];
        }

        // 1 step jump
        int jumpOne = frogJump(index - 1, height, dp)
                + Math.abs(height[index] - height[index - 1]);

        // 2 step jump
        int jumpTwo = Integer.MAX_VALUE;

        if (index > 1) {
            jumpTwo = frogJump(index - 2, height, dp)
                    + Math.abs(height[index] - height[index - 2]);
        }

        // Store minimum answer
        dp[index] = Math.min(jumpOne, jumpTwo);

        return dp[index];
    }

    public static void main(String[] args) {

        int[] height = {10, 20, 30, 10};

        int[] dp = new int[height.length];

        Arrays.fill(dp, -1);

        int answer = frogJump(height.length - 1, height, dp);

        System.out.println("Minimum Energy: " + answer);
    }
}
