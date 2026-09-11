package Recursion.medium;

import java.util.ArrayList;
import java.util.List;

public class CombinationIII {
    public static void generate(int start, int k, int remaining, List<Integer> current) {
        // base case
        if (remaining == 0 && k == 0) {
            System.out.println(current);
            return;
        }
        if (k == 0 || remaining < 0) {
            return;
        }
        for (int i = start; i <= 9; i++) {

            // Current element ko take
            current.add(i);
            generate(i + 1, k - 1, remaining - i, current);

            current.remove(current.size() - 1);

        }

    }

    public static void main(String[] args) {
        int k = 4, n = 17;
        generate(1, k, n, new ArrayList<>());

    }

}
