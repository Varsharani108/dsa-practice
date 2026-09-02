package Strings.Easy;

public class RotateString {

    public static boolean rotateString(String s, String goal) {

        // Length must be same
        if (s.length() != goal.length()) {
            return false;
        }

        // Check if goal exists inside s + s
        return (s + s).contains(goal);
    }

    public static void main(String[] args) {

        String s = "abcde";
        String goal = "cdeab";

        System.out.println(rotateString(s, goal));
    }
}
