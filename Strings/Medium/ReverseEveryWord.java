package Strings.Medium;

public class ReverseEveryWord {

    public static String reverseWords(String s) {

        String[] words = s.split(" ");
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < words.length; i++) {

            StringBuilder word = new StringBuilder(words[i]);

            result.append(word.reverse());

            if (i != words.length - 1) {
                result.append(" ");
            }
        }

        return result.toString();
    }

    public static void main(String[] args) {

        String s = "My name is Varsha";

        System.out.println(reverseWords(s));
    }
}