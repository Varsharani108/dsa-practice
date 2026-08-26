package Arrays.Bs_On_2D;

public class MatrixMedian {

    public static int findMedian(int[][] matrix) {

        int rows = matrix.length;
        int cols = matrix[0].length;

        int low = Integer.MAX_VALUE;
        int high = Integer.MIN_VALUE;

        // Find minimum and maximum element
        for (int i = 0; i < rows; i++) {

            low = Math.min(low, matrix[i][0]);
            high = Math.max(high, matrix[i][cols - 1]);
        }

        int required = (rows * cols + 1) / 2;

        while (low <= high) {

            int mid = low + (high - low) / 2;

            int count = 0;

            // Count elements <= mid
            for (int i = 0; i < rows; i++) {
                count += countLessEqual(matrix[i], mid);
            }

            if (count < required) {

                // mid is too small
                low = mid + 1;

            } else {

                // mid can be the answer
                high = mid - 1;
            }
        }

        return low;
    }

    // Binary search: count elements <= target
    public static int countLessEqual(int[] row, int target) {

        int low = 0;
        int high = row.length - 1;

        int ans = row.length;

        while (low <= high) {

            int mid = low + (high - low) / 2;

            if (row[mid] <= target) {

                low = mid + 1;

            } else {

                ans = mid;
                high = mid - 1;
            }
        }

        return ans;
    }

    public static void main(String[] args) {

        int[][] matrix = {
            {1, 3, 5},
            {2, 6, 9},
            {3, 6, 9}
        };

        System.out.println(findMedian(matrix));
    }
}
