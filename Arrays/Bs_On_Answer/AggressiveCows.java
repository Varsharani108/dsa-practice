import java.util.Arrays;

public class AggressiveCows {

    public static int aggressiveCows(int[] stalls, int k) {

        Arrays.sort(stalls);

        int low = 1;
        int high = stalls[stalls.length - 1] - stalls[0];
        int ans = 0;

        while (low <= high) {

            int mid = low + (high - low) / 2;

            if (canPlaceCows(stalls, k, mid)) {
                // This distance is possible
                ans = mid;

                // Try a bigger distance
                low = mid + 1;

            } else {
                // Distance is too large
                high = mid - 1;
            }
        }

        return ans;
    }

    public static boolean canPlaceCows(int[] stalls, int k, int distance) {

        // Place first cow
        int count = 1;
        int lastPosition = stalls[0];

        for (int i = 1; i < stalls.length; i++) {

            if (stalls[i] - lastPosition >= distance) {

                count++;
                lastPosition = stalls[i];

                if (count == k) {
                    return true;
                }
            }
        }

        return false;
    }

    public static void main(String[] args) {

        int[] stalls = {1, 2, 4, 8, 9};
        int k = 3;

        System.out.println(aggressiveCows(stalls, k));
    }
}