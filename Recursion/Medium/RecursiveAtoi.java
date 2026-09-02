package Recursion.medium;

public class RecursiveAtoi {

    public static int atoi(String s, int index, int result) {

        // Base case
        if (index == s.length()) {
            return result;
        }

        char ch = s.charAt(index);

        // Digit convert
        int digit = ch - '0';

        // Recursive call
        result = result * 10 + digit;

        return atoi(s, index + 1, result);
    }

    public static void main(String[] args) {

        String s = "1234";

        int result = atoi(s, 0, 0);

        System.out.println(result);
    }
}