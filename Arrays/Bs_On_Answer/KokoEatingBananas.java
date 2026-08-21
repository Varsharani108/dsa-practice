public class KokoEatingBananas {

    public static int minEatingSpeed(int[] piles, int h) {

        int low = 1;
        int high = 0;

        // Find maximum pile
        for (int pile : piles) {
            high = Math.max(high, pile);
        }

        int ans = high;

        while (low <= high) {

            int mid = low + (high - low) / 2;

            int hours = 0;

            // Calculate total hours at speed = mid
            for (int pile : piles) {
                hours += (pile + mid - 1) / mid;
            }

            if (hours <= h) {
                // This speed is possible
                ans = mid;
                high = mid - 1;
            } else {
                // Need more speed
                low = mid + 1;
            }
        }

        return ans;
    }

    public static void main(String[] args) {

        int[] piles = {3, 6, 7, 11};
        int h = 8;

        System.out.println(minEatingSpeed(piles, h));
    }
}