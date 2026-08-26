package Arrays.Bs_On_2D;
public class RowWithMaximumOnes {

    public static int findRowWithMaxOnes(int[][] matrix) {

        int maxOnes = 0;
        int rowIndex = -1;

        for (int i = 0; i < matrix.length; i++) {

            int low = 0;
            int high = matrix[i].length - 1;
            int firstOne = matrix[i].length;

            // Binary search for first 1
            while (low <= high) {

                int mid = low + (high - low) / 2;

                if (matrix[i][mid] == 1) {
                    firstOne = mid;
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }

            int ones = matrix[i].length - firstOne;

            if (ones > maxOnes) {
                maxOnes = ones;
                rowIndex = i;
            }
        }

        return rowIndex;
    }

    public static void main(String[] args) {

        int[][] matrix = {
            {0, 0, 0, 1},
            {0, 1, 1, 1},
            {0, 0, 1, 1},
            {0, 0, 0, 0}
        };

        System.out.println(findRowWithMaxOnes(matrix));
    }
}