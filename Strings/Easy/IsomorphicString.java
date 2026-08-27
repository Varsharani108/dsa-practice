package Strings.Easy;

import java.util.Arrays;

public class IsomorphicString {

    public static boolean isIsomorphic(String s, String t) {

        if (s.length() != t.length()) {
            return false;
        }

        int[] mapST = new int[256];
        int[] mapTS = new int[256];

        Arrays.fill(mapST, -1);
        Arrays.fill(mapTS, -1);

        for (int i = 0; i < s.length(); i++) {

            char ch1 = s.charAt(i);
            char ch2 = t.charAt(i);

            // Check s -> t mapping
            if (mapST[ch1] != -1 && mapST[ch1] != ch2) {
                return false;
            }

            // Check t -> s mapping
            if (mapTS[ch2] != -1 && mapTS[ch2] != ch1) {
                return false;
            }

            mapST[ch1] = ch2;
            mapTS[ch2] = ch1;
        }

        return true;
    }

    public static void main(String[] args) {

        String s = "egg";
        String t = "add";

        System.out.println(isIsomorphic(s, t));
    }
}