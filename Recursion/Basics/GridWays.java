package Recursion.Basics;

public class GridWays {

    public static int gridWays(int i, int j, int n, int m) {

        // Destination reached
        if(i == n - 1 && j == m - 1) {
            return 1;
        }

        // Out of grid
        if(i >= n || j >= m) {
            return 0;
        }

        // Move down
        int down = gridWays(i + 1, j, n, m);

        // Move right
        int right = gridWays(i, j + 1, n, m);

        return down + right;
    }

    public static void main(String[] args) {

        int n = 3;
        int m = 3;

        int ways = gridWays(0, 0, n, m);

        System.out.println("Total ways = " + ways);
    }
}