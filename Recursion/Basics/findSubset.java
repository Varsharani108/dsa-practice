package Recursion.Basics;

public class findSubset {

    public static void find(String str, int i, String ans) {

        // Base case
        if (i == str.length()) {
            if (ans.length() == 0) {
                System.out.println("null");
            } else {
                System.out.println(ans);
            }
            return;
        }
         // Choose current character
        find(str, i + 1, ans + str.charAt(i));

        // Don't choose current character
        find(str, i + 1, ans);

       
    }

    public static void main(String[] args) {
        String str = "abc";
        String ans = "";

        find(str, 0, ans);
    }
}