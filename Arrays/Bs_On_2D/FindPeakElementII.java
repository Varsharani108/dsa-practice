package Arrays.Bs_On_2D;

public class FindPeakElementII {

    public static int[] findPeakGrid(int[][] matrix) {

        int rows = matrix.length;
        int cols = matrix[0].length;

        int low = 0;
        int high = cols - 1;

        while (low <= high) {

            // Middle column
            int midCol = low + (high - low) / 2;

            // Find maximum element in middle column
            int maxRow = 0;

            for (int row = 1; row < rows; row++) {
                if (matrix[row][midCol] > matrix[maxRow][midCol]) {
                    maxRow = row;
                }
            }

            int left = (midCol == 0)
                    ? -1
                    : matrix[maxRow][midCol - 1];

            int right = (midCol == cols - 1)
                    ? -1
                    : matrix[maxRow][midCol + 1];

            int current = matrix[maxRow][midCol];

            // Current element is a peak
            if (current > left && current > right) {
                return new int[]{maxRow, midCol};
            }

            // Right side has a bigger element
            if (right > current) {
                low = midCol + 1;
            }

            // Left side has a bigger element
            else {
                high = midCol - 1;
            }
        }

        return new int[]{-1, -1};
    }

    public static void main(String[] args) {

        int[][] matrix = {
            {10, 20, 15},
            {21, 30, 14},
            {7, 16, 32}
        };

        int[] result = findPeakGrid(matrix);

        System.out.println(
            "Peak at: [" + result[0] + ", " + result[1] + "]"
        );

        System.out.println(
            "Peak value: " + matrix[result[0]][result[1]]
        );
    }
}