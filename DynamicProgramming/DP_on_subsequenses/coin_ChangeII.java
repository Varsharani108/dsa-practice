package DynamicProgramming.DP_on_subsequenses;

import java.util.Arrays;
public class coin_ChangeII {
    public static int coinchange(int idx, int[] coins,int amount, int[][] dp){
        if(amount==0){
            return 1;
        }
        if (idx == 0) {
            if (amount % coins[0] == 0) {
                return 1;
            }
            return 0;
        }

        if (dp[idx][amount] != -1) {
            return dp[idx][amount];
        }
        int ways=0;
        for(int coinAmount=0;coinAmount<=amount;coinAmount +=coins[idx]){
            ways += coinchange(idx-1,coins,amount-coinAmount,dp);
        }
        return dp[idx][amount]=ways;

    }
    public static void main(String[] args) {

        int[] coins = {1, 2, 5};

        int amount = 11;
        int idx=coins.length -1;

        int[][] dp = new int[idx+1][amount+1];

        for(int[] row : dp) {
          Arrays.fill(row, -1);
        }

        int ways = coinchange(idx,coins,amount, dp);
        System.out.println(ways);
        
    }

    
}
