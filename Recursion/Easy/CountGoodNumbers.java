package Recursion.Easy;

public class CountGoodNumbers {

    static long MOD = 1000000007;

    public static long power(long x, long n) {

        if (n == 0) {
            return 1;
        }

        long half = power(x, n / 2);

        if (n % 2 == 0) {
            return (half * half) % MOD;
        } else {
            return (x * half % MOD * half) % MOD;
        }
    }

    public static int countGoodNumbers(long n) {

        long evenPositions = (n + 1) / 2;
        long oddPositions = n / 2;

        long result = power(5, evenPositions)
                    * power(4, oddPositions) % MOD;

        return (int) result;
    }

    public static void main(String[] args) {

        long n = 4;

        System.out.println(countGoodNumbers(n));
    }
}