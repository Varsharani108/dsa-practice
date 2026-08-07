package Arrays.level3;

import java.util.ArrayList;
import java.util.List;

public class PascalsTriangle {

    public static List<List<Integer>> generate(int n) {

        List<List<Integer>> ans = new ArrayList<>();

        for (int row = 1; row <= n; row++) {

            List<Integer> currentRow = new ArrayList<>();

            int value = 1;
            currentRow.add(value);

            for (int col = 1; col < row; col++) {

                value = value * (row - col) / col;
                currentRow.add(value);
            }

            ans.add(currentRow);
        }

        return ans;
    }

    public static void main(String[] args) {

        int n = 5;

        System.out.println(generate(n));
    }
}