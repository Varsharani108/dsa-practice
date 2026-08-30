package Strings.Hard;

import java.util.Arrays;

public class ZFunction {

    public static int[] calculateZ(String s) {

        int n = s.length();

        int[] z = new int[n];

        int left = 0;
        int right = 0;

        for (int i = 1; i < n; i++) {

            // If i is inside the current Z-box
            if (i <= right) {
                z[i] = Math.min(right - i + 1, z[i - left]);
            }

            // Try to extend the match
            while (i + z[i] < n
                    && s.charAt(z[i]) == s.charAt(i + z[i])) {

                z[i]++;
            }

            // Update Z-box
            if (i + z[i] - 1 > right) {

                left = i;
                right = i + z[i] - 1;
            }
        }

        return z;
    }

    public static void main(String[] args) {

        String s = "aabcaab";

        int[] z = calculateZ(s);

        System.out.println(Arrays.toString(z));
    }
}