package Recursion.Hard;

import java.util.*;

public class PalindromePartitioning {

    static void partition(String s, int index, List<String> current) {

        // Base case
        if (index == s.length()) {
            System.out.println(current);
            return;
        }

        // Try every possible substring
        for (int i = index; i < s.length(); i++) {

            String part = s.substring(index, i + 1);

            // Check palindrome
            if (isPalindrome(part)) {

                // Choose
                current.add(part);

                // Recursion
                partition(s, i + 1, current);

                // Backtrack
                current.remove(current.size() - 1);
            }
        }
    }

    static boolean isPalindrome(String s) {

        int left = 0;
        int right = s.length() - 1;

        while (left < right) {

            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }

            left++;
            right--;
        }

        return true;
    }

    public static void main(String[] args) {

        String s = "aab";

        partition(s, 0, new ArrayList<>());
    }
}
