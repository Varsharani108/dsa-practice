package DynamicProgramming.DP_on_subsequenses;

import java.util.*;

public class FractionalKnapsack {

    public static double fractionalKnapsack(int W, int wt[], int val[]) {

        // {ratio, index}
        ArrayList<double[]> list = new ArrayList<>();

        for (int i = 0; i < wt.length; i++) {
            double ratio = (double) val[i] / wt[i];
            list.add(new double[]{ratio, i});
        }

        // Sort according to ratio in descending order
        Collections.sort(list, (a, b) -> Double.compare(b[0], a[0]));

        double ans = 0;

        for (double[] x : list) {

            int i = (int) x[1];

            if (wt[i] <= W) {
                ans += val[i];
                W -= wt[i];
            } 
            else {
                ans += x[0] * W;
                break;
            }
        }

        return ans;
    }

    public static void main(String args[]) {

        int wt[] = {10, 20, 30};
        int val[] = {60, 100, 120};

        int W = 50;

        System.out.println(fractionalKnapsack(W, wt, val));
    }
}
