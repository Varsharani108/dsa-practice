public class CapacityToShip{

    public static int shipWithinDays(int[] weights, int days) {

        int low = 0;
        int high = 0;

        // Minimum capacity = maximum package weight
        // Maximum capacity = sum of all weights
        for (int weight : weights) {
            low = Math.max(low, weight);
            high += weight;
        }

        int ans = high;

        while (low <= high) {

            int mid = low + (high - low) / 2;

            int daysNeeded = 1;
            int currentWeight = 0;

            // Check how many days are needed
            // with capacity = mid
            for (int weight : weights) {

                if (currentWeight + weight <= mid) {
                    currentWeight += weight;
                } else {
                    // Start a new day
                    daysNeeded++;
                    currentWeight = weight;
                }
            }

            if (daysNeeded <= days) {
                // Capacity is possible
                ans = mid;
                high = mid - 1;
            } else {
                // Capacity is too small
                low = mid + 1;
            }
        }

        return ans;
    }

    public static void main(String[] args) {

        int[] weights = {
            1, 2, 3, 4, 5, 6, 7, 8, 9, 10
        };

        int days = 5;

        System.out.println(shipWithinDays(weights, days));
    }
}