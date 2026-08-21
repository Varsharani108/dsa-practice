public class MinimumDaysBouquets {

    public static int minDays(int[] bloomDay, int m, int k) {

        // Total flowers required
        if ((long) m * k > bloomDay.length) {
            return -1;
        }

        int low = 1;
        int high = 0;

        // Find maximum bloom day
        for (int day : bloomDay) {
            high = Math.max(high, day);
        }

        int ans = -1;

        while (low <= high) {

            int mid = low + (high - low) / 2;

            int bouquets = 0;
            int flowers = 0;

            for (int day : bloomDay) {

                if (day <= mid) {
                    // Flower has bloomed
                    flowers++;

                    if (flowers == k) {
                        bouquets++;
                        flowers = 0;
                    }

                } else {
                    // Not bloomed, so adjacency breaks
                    flowers = 0;
                }
            }

            if (bouquets >= m) {
                // Possible, try fewer days
                ans = mid;
                high = mid - 1;
            } else {
                // Not possible, need more days
                low = mid + 1;
            }
        }

        return ans;
    }

    public static void main(String[] args) {

        int[] bloomDay = {1, 2, 1, 2, 1, 2};

        int m = 3;
        int k = 2;

        System.out.println(minDays(bloomDay, m, k));
    }
}