package Strings.Hard;

public class RabinKarp {

    static final int BASE = 256;
    static final int MOD = 101;

    public static int search(String text, String pattern) {

        int n = text.length();
        int m = pattern.length();

        if (m == 0) {
            return 0;
        }

        if (m > n) {
            return -1;
        }

        int patternHash = 0;
        int windowHash = 0;
        int highestPower = 1;

        // BASE^(m-1)
        for (int i = 0; i < m - 1; i++) {
            highestPower = (highestPower * BASE) % MOD;
        }

        // Calculate initial hashes
        for (int i = 0; i < m; i++) {

            patternHash =
                    (BASE * patternHash + pattern.charAt(i)) % MOD;

            windowHash =
                    (BASE * windowHash + text.charAt(i)) % MOD;
        }

        // Slide the window
        for (int i = 0; i <= n - m; i++) {

            // Hash matches
            if (patternHash == windowHash) {

                // Verify actual characters
                if (text.substring(i, i + m).equals(pattern)) {
                    return i;
                }
            }

            // Calculate next window hash
            if (i < n - m) {

                windowHash =
                        BASE * (windowHash
                        - text.charAt(i) * highestPower)
                        + text.charAt(i + m);

                windowHash = windowHash % MOD;

                if (windowHash < 0) {
                    windowHash += MOD;
                }
            }
        }

        return -1;
    }

    public static void main(String[] args) {

        String text = "abcdef";
        String pattern = "cde";

        System.out.println(search(text, pattern));
    }
}