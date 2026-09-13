package DynamicProgramming.oneD_dp;

public class FrogJumpK {

    static int frogJump(int[] height, int k) {

        int n = height.length;

        int[] dp = new int[n];

        dp[0] = 0;

        for (int i = 1; i < n; i++) {

            int minEnergy = Integer.MAX_VALUE;

            for (int j = 1; j <= k; j++) {

                if (i - j >= 0) {

                    int energy = dp[i - j]
                            + Math.abs(height[i] - height[i - j]);

                    minEnergy = Math.min(minEnergy, energy);
                }
            }

            dp[i] = minEnergy;
        }

        return dp[n - 1];
    }

    public static void main(String[] args) {

        int[] height = {10, 30, 40, 50, 20};

        int k = 3;

        int answer = frogJump(height, k);

        System.out.println("Minimum Energy: " + answer);
    }
}