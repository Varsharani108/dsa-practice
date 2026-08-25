package Arrays.Bs_On_2D;

public class SearchIn2DMatrixII {

    public static boolean searchMatrix(int[][] matrix, int target) {

        int rows = matrix.length;
        int cols = matrix[0].length;

        // Start from top-right corner
        int row = 0;
        int col = cols - 1;

        while (row < rows && col >= 0) {

            int current = matrix[row][col];

            if (current == target) {
                return true;
            }

            if (current > target) {
                // Move left
                col--;
            } else {
                // Move down
                row++;
            }
        }

        return false;
    }

    public static void main(String[] args) {

        int[][] matrix = {
            {1, 4, 7, 11, 15},
            {2, 5, 8, 12, 19},
            {3, 6, 9, 16, 22},
            {10, 13, 14, 17, 24},
            {18, 21, 23, 26, 30}
        };

        int target = 16;

        System.out.println(searchMatrix(matrix, target));
    }
}
