package Strings.Hard;

public class MinimumBracketReversals {

    public static int minReversals(String s) {

        // Odd length can never be balanced
        if (s.length() % 2 != 0) {
            return -1;
        }

        int open = 0;
        int close = 0;

        for (char ch : s.toCharArray()) {

            if (ch == '(') {

                open++;

            } else {

                if (open > 0) {
                    open--;
                } else {
                    close++;
                }
            }
        }

        int reversals = (open + 1) / 2
                      + (close + 1) / 2;

        return reversals;
    }

    public static void main(String[] args) {

        String s = "))((";

        System.out.println(minReversals(s));
    }
}