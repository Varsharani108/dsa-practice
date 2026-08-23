public class PaintersPartition {

    public static int minTime(int[] boards, int painters) {

        int low = 0;
        int high = 0;

        // Minimum possible time = largest board
        // Maximum possible time = total board length
        for (int board : boards) {
            low = Math.max(low, board);
            high += board;
        }

        int ans = high;

        while (low <= high) {

            int mid = low + (high - low) / 2;

            int paintersRequired = 1;
            int currentTime = 0;

            // Check how many painters are required
            // if maximum time allowed = mid
            for (int board : boards) {

                if (currentTime + board <= mid) {
                    currentTime += board;
                } else {
                    paintersRequired++;
                    currentTime = board;
                }
            }

            if (paintersRequired <= painters) {

                // Possible
                ans = mid;

                // Try smaller maximum time
                high = mid - 1;

            } else {

                // Need more painters
                low = mid + 1;
            }
        }

        return ans;
    }

    public static void main(String[] args) {

        int[] boards = {10, 20, 30, 40};
        int painters = 2;

        System.out.println(minTime(boards, painters));
    }
}