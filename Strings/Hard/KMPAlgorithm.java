package Strings.Hard;

public class KMPAlgorithm {

    // Create LPS array
    public static int[] createLPS(String pattern) {

        int n = pattern.length();
        int[] lps = new int[n];

        int length = 0;
        int i = 1;

        while (i < n) {

            if (pattern.charAt(i) == pattern.charAt(length)) {

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

    // KMP Search
    public static int search(String text, String pattern) {

        if (pattern.length() == 0) {
            return 0;
        }

        int[] lps = createLPS(pattern);

        int i = 0;
        int j = 0;

        while (i < text.length()) {

            if (text.charAt(i) == pattern.charAt(j)) {

                i++;
                j++;

                if (j == pattern.length()) {
                    return i - j;
                }

            } else {

                if (j != 0) {
                    j = lps[j - 1];
                } else {
                    i++;
                }
            }
        }

        return -1;
    }

    public static void main(String[] args) {

        String text = "ababcabc";
        String pattern = "abc";

        System.out.println(search(text, pattern));
    }
}