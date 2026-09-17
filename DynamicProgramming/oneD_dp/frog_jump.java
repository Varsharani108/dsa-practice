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

//tabulation method(bottomup approach) of frog jump

// package DynamicProgramming.oneD_dp;

// public class frog_jump {

//     static int frogJump(int[] height) {

//         int n = height.length;

//         int[] dp = new int[n];

//         dp[0] = 0;

//         for (int i = 1; i < n; i++) {

//             int jumpOne = dp[i - 1]
//                     + Math.abs(height[i] - height[i - 1]);

//             int jumpTwo = Integer.MAX_VALUE;

//             if (i > 1) {
//                 jumpTwo = dp[i - 2]
//                         + Math.abs(height[i] - height[i - 2]);
//             }

//             dp[i] = Math.min(jumpOne, jumpTwo);
//         }

//         return dp[n - 1];
//     }

//     public static void main(String[] args) {

//         int[] height = {10, 20, 30, 10};

//         int answer = frogJump(height);

//         System.out.println("Minimum Energy: " + answer);
//     }
// }

// Frog Jump ka Space Optimization

// package DynamicProgramming.oneD_dp;

// public class frog_jump {

//     static int frogJump(int[] height) {

//         int n = height.length;

//         int prev2 = 0;
//         int prev = 0;

//         for (int i = 1; i < n; i++) {

//             int jumpOne = prev
//                     + Math.abs(height[i] - height[i - 1]);

//             int jumpTwo = Integer.MAX_VALUE;

//             if (i > 1) {
//                 jumpTwo = prev2
//                         + Math.abs(height[i] - height[i - 2]);
//             }

//             int curr = Math.min(jumpOne, jumpTwo);

//             prev2 = prev;
//             prev = curr;
//         }

//         return prev;
//     }

//     public static void main(String[] args) {

//         int[] height = {10, 20, 30, 10};

//         int answer = frogJump(height);

//         System.out.println("Minimum Energy: " + answer);
//     }
// }