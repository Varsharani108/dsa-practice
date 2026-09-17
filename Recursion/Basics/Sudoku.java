package Recursion.Basics;

public class Sudoku {

    public static boolean isSafe(int[][] sudoku, int row, int col, int digit) {

        // Check row
        for(int j = 0; j < 9; j++) {
            if(sudoku[row][j] == digit) {
                return false;
            }
        }

        // Check column
        for(int i = 0; i < 9; i++) {
            if(sudoku[i][col] == digit) {
                return false;
            }
        }

        // Check 3x3 box
        int startRow = (row / 3) * 3;
        int startCol = (col / 3) * 3;

        for(int i = startRow; i < startRow + 3; i++) {
            for(int j = startCol; j < startCol + 3; j++) {

                if(sudoku[i][j] == digit) {
                    return false;
                }
            }
        }

        return true;
    }

    public static boolean solveSudoku(int[][] sudoku, int row, int col) {

        // All cells completed
        if(row == 9) {
            return true;
        }

        // Move to next row
        if(col == 9) {
            return solveSudoku(sudoku, row + 1, 0);
        }

        // Already filled cell
        if(sudoku[row][col] != 0) {
            return solveSudoku(sudoku, row, col + 1);
        }

        // Try digits 1 to 9
        for(int digit = 1; digit <= 9; digit++) {

            if(isSafe(sudoku, row, col, digit)) {

                // Place digit
                sudoku[row][col] = digit;

                // Recursion
                if(solveSudoku(sudoku, row, col + 1)) {
                    return true;
                }

                // Backtracking
                sudoku[row][col] = 0;
            }
        }

        return false;
    }

    public static void printSudoku(int[][] sudoku) {

        for(int i = 0; i < 9; i++) {

            for(int j = 0; j < 9; j++) {
                System.out.print(sudoku[i][j] + " ");
            }

            System.out.println();
        }
    }

    public static void main(String[] args) {

        int[][] sudoku = {
            {5, 3, 0, 0, 7, 0, 0, 0, 0},
            {6, 0, 0, 1, 9, 5, 0, 0, 0},
            {0, 9, 8, 0, 0, 0, 0, 6, 0},

            {8, 0, 0, 0, 6, 0, 0, 0, 3},
            {4, 0, 0, 8, 0, 3, 0, 0, 1},
            {7, 0, 0, 0, 2, 0, 0, 0, 6},

            {0, 6, 0, 0, 0, 0, 2, 8, 0},
            {0, 0, 0, 4, 1, 9, 0, 0, 5},
            {0, 0, 0, 0, 8, 0, 0, 7, 9}
        };

        if(solveSudoku(sudoku, 0, 0)) {
            System.out.println("Sudoku Solved:");
            printSudoku(sudoku);
        } else {
            System.out.println("No solution exists.");
        }
    }
}