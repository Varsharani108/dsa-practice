package Strings.Hard;

public class ShortestPalindrome {

    public static String shortestPalindrome(String s) {

        if (s == null || s.length() <= 1) {
            return s;
        }

        String reverse = new StringBuilder(s)
                .reverse()
                .toString();

        String combined = s + "#" + reverse;

        int[] lps = createLPS(combined);

        int longestPalindromePrefix = lps[combined.length() - 1];

        String remaining = s.substring(longestPalindromePrefix);

        String add = new StringBuilder(remaining)
                .reverse()
                .toString();

        return add + s;
    }

    public static int[] createLPS(String s) {

        int[] lps = new int[s.length()];

        int length = 0;
        int i = 1;

        while (i < s.length()) {

            if (s.charAt(i) == s.charAt(length)) {

                length++;
                lps[i] = length;
                i++;

            } else {

                if (length != 0) {
                    length = lps[length - 1];
                } else {
                    lps[i] = 0;
                    i++;
                }
            }
        }

        return lps;
    }

    public static void main(String[] args) {

        String s = "abcd";

        System.out.println(shortestPalindrome(s));
    }
}