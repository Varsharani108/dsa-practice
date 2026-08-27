package Strings.Easy;

public class CheckAnagram {

    public static boolean isAnagram(String s, String t) {

        if (s.length() != t.length()) {
            return false;
        }

        int[] count = new int[256];

        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i)]++;
            count[t.charAt(i)]--;
        }

        for (int value : count) {
            if (value != 0) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {

        String s = "listen";
        String t = "silent";

        System.out.println(isAnagram(s, t));
    }
}