public class MinimizeMaxDistance {

    public static double minmaxGasDist(int[] stations, int k) {

        double low = 0;
        double high = stations[stations.length - 1] - stations[0];

        // Binary search for decimal answer
        for (int i = 0; i < 100; i++) {

            double mid = low + (high - low) / 2;

            int requiredStations = 0;

            // Count how many new stations are required
            for (int j = 1; j < stations.length; j++) {

                double gap = stations[j] - stations[j - 1];

                int required = (int) Math.ceil(gap / mid) - 1;

                requiredStations += required;
            }

            if (requiredStations <= k) {

                // Possible
                // Try smaller maximum distance
                high = mid;

            } else {

                // Not possible
                // Need a larger distance
                low = mid;
            }
        }

        return high;
    }

    public static void main(String[] args) {

        int[] stations = {1, 7};
        int k = 2;

        System.out.println(minmaxGasDist(stations, k));
    }
}