package Strings.Easy;

public class RemoveOutermostParentheses {

    public static String removeOuterParentheses(String s) {

        StringBuilder result = new StringBuilder();

        int count = 0;

        for (int i = 0; i < s.length(); i++) {

            char ch = s.charAt(i);

            if (ch == '(') {

                // Add only non-outermost '('
                if (count > 0) {
                    result.append(ch);
                }

                count++;

            } else {

                count--;

                // Add only non-outermost ')'
                if (count > 0) {
                    result.append(ch);
                }
            }
        }

        return result.toString();
    }

    public static void main(String[] args) {

        String s = "(()())(())";

        System.out.println(removeOuterParentheses(s));
    }
}
