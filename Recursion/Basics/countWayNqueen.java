package Recursion.Basics;

public class countWayNqueen {

    static int count = 0;

    public static boolean isSafe(char[][] board, int row, int col) {

        // Same column
        for(int i = row - 1; i >= 0; i--) {
            if(board[i][col] == 'Q') {
                return false;
            }
        }

        // Upper-left diagonal
        for(int i = row - 1, j = col - 1;
            i >= 0 && j >= 0;
            i--, j--) {

            if(board[i][j] == 'Q') {
                return false;
            }
        }

        // Upper-right diagonal
        for(int i = row - 1, j = col + 1;
            i >= 0 && j < board.length;
            i--, j++) {

            if(board[i][j] == 'Q') {
                return false;
            }
        }

        return true;
    }

    public static void Queen(char[][] board, int row) {

        // One complete solution found
        if(row == board.length) {
            count++;
            return;
        }

        for(int j = 0; j < board.length; j++) {

            if(isSafe(board, row, j)) {

                board[row][j] = 'Q';

                Queen(board, row + 1);

                // Backtracking
                board[row][j] = 'X';
            }
        }
    }

    public static void main(String[] args) {

        int n = 4;

        char[][] board = new char[n][n];

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                board[i][j] = 'X';
            }
        }

        Queen(board, 0);

        System.out.println("Total ways = " + count);
    }
}