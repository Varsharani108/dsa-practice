public class SplitArrayLargestSum {

    public static int splitArray(int[] nums, int k) {

        int low = 0;
        int high = 0;

        // Minimum possible answer = maximum element
        // Maximum possible answer = total sum
        for (int num : nums) {
            low = Math.max(low, num);
            high += num;
        }

        int ans = high;

        while (low <= high) {

            int mid = low + (high - low) / 2;

            int parts = 1;
            int currentSum = 0;

            // Count how many parts are needed
            // if maximum allowed sum = mid
            for (int num : nums) {

                if (currentSum + num <= mid) {
                    currentSum += num;
                } else {
                    parts++;
                    currentSum = num;
                }
            }

            if (parts <= k) {

                // Possible
                ans = mid;

                // Try smaller maximum sum
                high = mid - 1;

            } else {

                // Need more parts
                low = mid + 1;
            }
        }

        return ans;
    }

    public static void main(String[] args) {

        int[] nums = {7, 2, 5, 10, 8};
        int k = 2;

        System.out.println(splitArray(nums, k));
    }
}