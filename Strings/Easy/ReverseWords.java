package Strings.Easy;

package Strings.Easy;

public class ReverseWords {

    public static String reverseWords(String s) {

        // Remove extra spaces from beginning and end
        s = s.trim();

        // Split words using one or more spaces
        String[] words = s.split("\\s+");

        StringBuilder result = new StringBuilder();

        // Add words from right to left
        for (int i = words.length - 1; i >= 0; i--) {

            result.append(words[i]);

            if (i != 0) {
                result.append(" ");
            }
        }

        return result.toString();
    }

    public static void main(String[] args) {

        String s = "I love Java";

        System.out.println(reverseWords(s));
    }
}