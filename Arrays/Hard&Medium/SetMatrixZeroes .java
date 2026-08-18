package Arrays.level3;

public class SetMatrixZeroes {

    public static void setZeroes(int[][] matrix) {

        int n = matrix.length;
        int m = matrix[0].length;

        int[] row = new int[n];
        int[] col = new int[m];

        // Step 1: Mark rows and columns
        for (int i = 0; i < n; i++) {

            for (int j = 0; j < m; j++) {

                if (matrix[i][j] == 0) {
                    row[i] = 1;
                    col[j] = 1;
                }
            }
        }

        // Step 2: Set zeroes
        for (int i = 0; i < n; i++) {

            for (int j = 0; j < m; j++) {

                if (row[i] == 1 || col[j] == 1) {
                    matrix[i][j] = 0;
                }
            }
        }
    }

    public static void printMatrix(int[][] matrix) {

        for (int[] rows : matrix) {

            for (int num : rows) {
                System.out.print(num + " ");
            }

            System.out.println();
        }
    }

    public static void main(String[] args) {

        int[][] matrix = {
                {1, 1, 1},
                {1, 0, 1},
                {1, 1, 1}
        };

        setZeroes(matrix);

        printMatrix(matrix);
    }
}