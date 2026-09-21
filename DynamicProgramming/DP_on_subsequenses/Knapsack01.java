package DynamicProgramming.DP_on_subsequenses;

public class Knapsack01 {

    public static int knapsack(int wt[], int val[], int W) {

        int n = wt.length;

        int dp[][] = new int[n + 1][W + 1];

        // i = number of items
        for (int i = 1; i <= n; i++) {

            // j = current capacity
            for (int j = 1; j <= W; j++) {

                // If current item can fit
                if (wt[i - 1] <= j) {

                    // Include OR exclude
                    dp[i][j] = Math.max(
                        val[i - 1] + dp[i - 1][j - wt[i - 1]],
                        dp[i - 1][j]
                    );

                } else {

                    // Cannot include current item
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        return dp[n][W];
    }

    public static void main(String args[]) {

        int wt[] = {1, 2, 3, 5};
        int val[] = {5, 10, 15, 20};

        int W = 6;

        System.out.println(knapsack(wt, val, W));
    }
}