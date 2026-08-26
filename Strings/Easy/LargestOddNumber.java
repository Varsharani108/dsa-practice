package Strings.Easy;

package Strings.Easy;

public class LargestOddNumber {

    public static String largestOddNumber(String s) {

        // Check from right to left
        for (int i = s.length() - 1; i >= 0; i--) {

            int digit = s.charAt(i) - '0';

            // If digit is odd
            if (digit % 2 != 0) {
                return s.substring(0, i + 1);
            }
        }

        // No odd digit found
        return "";
    }

    public static void main(String[] args) {

        String s = "35427";

        System.out.println(largestOddNumber(s));
    }
}
