package Strings.Hard;

public class LongestHappyPrefix {

    public static String longestPrefix(String s) {

        int[] lps = createLPS(s);

        int length = lps[s.length() - 1];

        return s.substring(0, length);
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

        String s = "ababab";

        System.out.println(longestPrefix(s));
    }
}