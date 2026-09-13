package DynamicProgramming.DP_on_subsequenses;

import java.util.Arrays;

public class coin_Change {

    static int coinChange(int[] coins, int amount, int[] dp) {

        if (amount == 0) {
            return 0;
        }

        if (amount < 0) {
            return Integer.MAX_VALUE;
        }

        if (dp[amount] != -1) {
            return dp[amount];
        }

        int minCoins = Integer.MAX_VALUE;

        for (int coin : coins) {

            int result = coinChange(coins, amount - coin, dp);

            if (result != Integer.MAX_VALUE) {
                minCoins = Math.min(minCoins, result + 1);
            }
        }

        dp[amount] = minCoins;

        return dp[amount];
    }

    public static void main(String[] args) {

        int[] coins = {1, 2, 5};

        int amount = 11;

        int[] dp = new int[amount + 1];

        Arrays.fill(dp, -1);

        int answer = coinChange(coins, amount, dp);

        if (answer == Integer.MAX_VALUE) {
            answer = -1;
        }

        System.out.println("Minimum Coins: " + answer);
    }
}

// Through tabulation method(bottom-up approach) of coin change problem

// package DynamicProgramming.DP_on_subsequenses;

// import java.util.Arrays;

// public class coin_Change {

//     static int coinChange(int[] coins, int amount) {

//         int[] dp = new int[amount + 1];

//         Arrays.fill(dp, amount + 1);

//         dp[0] = 0;

//         for (int i = 1; i <= amount; i++) {

//             for (int coin : coins) {

//                 if (coin <= i) {

//                     dp[i] = Math.min(
//                             dp[i],
//                             1 + dp[i - coin]
//                     );
//                 }
//             }
//         }

//         if (dp[amount] > amount) {
//             return -1;
//         }

//         return dp[amount];
//     }

//     public static void main(String[] args) {

//         int[] coins = {1, 2, 5};

//         int amount = 11;

//         int answer = coinChange(coins, amount);

//         System.out.println("Minimum Coins: " + answer);
//     }
// }