public class NthRoot {

    public static int findNthRoot(int n, int m) {

        int low = 1;
        int high = m;

        while (low <= high) {

            int mid = low + (high - low) / 2;

            int result = power(mid, n, m);

            if (result == m) {
                return mid;
            } else if (result < m) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return -1;
    }

    // Returns:
    // 0  -> power is less than m
    // 1  -> power is equal to m
    // 2  -> power is greater than m
    public static int power(int base, int exponent, int limit) {

        long result = 1;

        for (int i = 1; i <= exponent; i++) {

            result *= base;

            if (result > limit) {
                return 2;
            }
        }

        if (result == limit) {
            return 1;
        }

        return 0;
    }

    public static void main(String[] args) {

        int n = 3;
        int m = 27;

        System.out.println(findNthRoot(n, m));
    }
}