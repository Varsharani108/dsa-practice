package DynamicProgramming.DP_on_subsequenses;

public class RodCutting {

    public static int rodCutting(int price[], int n) {

        int dp[] = new int[n + 1];

        // dp[0] = 0
        for (int length = 1; length <= n; length++) {

            int maxProfit = 0;

            // Try every possible cut
            for (int cut = 1; cut <= length; cut++) {

                maxProfit = Math.max(
                    maxProfit,
                    price[cut - 1] + dp[length - cut]
                );
            }

            dp[length] = maxProfit;
        }

        return dp[n];
    }

    public static void main(String args[]) {

        int price[] = {1, 5, 8, 9, 10, 17, 17, 20};

        int n = 8;

        System.out.println(rodCutting(price, n));
    }
}
