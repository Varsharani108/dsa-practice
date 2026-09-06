package Recursion.medium;

public class GenerateParentheses {

    public static void generate(String str, int open, int close, int n) {

        // Base case
        if (str.length() == 2 * n) {
            System.out.println(str);
            return;
        }

        // Add opening bracket
        if (open < n) {
            generate(str + "(", open + 1, close, n);
        }

        // Add closing bracket only when valid
        if (close < open) {
            generate(str + ")", open, close + 1, n);
        }
    }

    public static void main(String[] args) {

        int n = 3;

        generate("", 0, 0, n);
    }
}
