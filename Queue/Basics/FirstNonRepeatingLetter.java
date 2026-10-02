package Queue.Basics;
import java.util.*;

public class FirstNonRepeatingLetter {

    public static void firstNonRepeating(String str) {

        int freq[] = new int[26];

        Queue<Character> q = new LinkedList<>();

        for (int i = 0; i < str.length(); i++) {

            char ch = str.charAt(i);

            // frequency increase
            freq[ch - 'a']++;

            // character queue mein add
            q.add(ch);

            // repeating characters remove
            while (!q.isEmpty() && freq[q.peek() - 'a'] > 1) {
                q.remove();
            }

            // first non-repeating character
            if (q.isEmpty()) {
                System.out.print("-1 ");
            } else {
                System.out.print(q.peek() + " ");
            }
        }
    }

    public static void main(String[] args) {

        String str = "aabccxb";

        firstNonRepeating(str);
    }
}