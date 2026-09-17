//Print all binary strings of size N without consecutive ones
package Recursion.Basics;

public class BinaryString {
    public static void print(int n, int lastPlace, StringBuilder str) {

        if (n == 0) {
            System.out.println(str);
            return;
        }

        str.append("0");
        print(n - 1, 0, str);
        str.deleteCharAt(str.length() - 1);

        if (lastPlace == 0) {
            str.append("1");
            print(n - 1, 1, str);
            str.deleteCharAt(str.length() - 1);
        }
    }

    public static void main(String args[]) {
        print(3, 0, new StringBuilder(""));
    }

}
