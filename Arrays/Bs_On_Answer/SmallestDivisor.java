public class SmallestDivisor {

    public static int findSmallestDivisor(int[] nums, int threshold) {

        int low = 1;
        int high = 0;

        // Find maximum element
        for (int num : nums) {
            high = Math.max(high, num);
        }

        int ans = high;

        while (low <= high) {

            int mid = low + (high - low) / 2;

            int sum = 0;

            // Calculate sum using divisor = mid
            for (int num : nums) {
                sum += (num + mid - 1) / mid;
            }

            if (sum <= threshold) {
                // Possible, try smaller divisor
                ans = mid;
                high = mid - 1;
            } else {
                // Not possible, need bigger divisor
                low = mid + 1;
            }
        }

        return ans;
    }

    public static void main(String[] args) {

        int[] nums = {1, 2, 5, 9};
        int threshold = 6;

        System.out.println(findSmallestDivisor(nums, threshold));
    }
}