package Recursion.Medium;

public class PowXn {

    public static double myPow(double x, int n) {

        if (n == 0) {
            return 1;
        }

        long N = n;

        if (N < 0) {
            return 1 / myPow(x, (int) -N);
        }

        double half = myPow(x, (int) (N / 2));

        if (N % 2 == 0) {
            return half * half;
        } else {
            return x * half * half;
        }
    }

    public static void main(String[] args) {

        double x = 2;
        int n = 5;

        System.out.println(myPow(x, n));
    }
}