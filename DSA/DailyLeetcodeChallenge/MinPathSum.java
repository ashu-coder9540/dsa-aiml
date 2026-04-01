import java.util.Arrays;

public class MinPathSum {
    // Approach 1: Recursion + Memoization -> Top Down DP
    // Time Complexity: O(m*n) -> Each cell is computed once
    // Space Complexity: O(m*n) -> For the memoization table and recursion stack
    private static int solve(int[][] grid, int i, int j, int m, int n, int[][] t) {
        // Base Case
        if (i == m - 1 && j == n - 1) {
            return t[i][j] = grid[i][j];
        }

        if (t[i][j] != -1)
            return t[i][j];

        // recursive work
        if (i == m - 1) { // can go only right
            return t[i][j] = grid[i][j] + solve(grid, i, j + 1, m, n, t);
        } else if (j == n - 1) { // can go only down
            return t[i][j] = grid[i][j] + solve(grid, i + 1, j, m, n, t);
        } else {
            return t[i][j] = grid[i][j] + Math.min(solve(grid, i + 1, j, m, n, t), solve(grid, i, j + 1, m, n, t));
        }
    }

    public static int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] t = new int[m + 1][n + 1];
        for (int[] row : t) {
            Arrays.fill(row, -1);
        }
        return solve(grid, 0, 0, m, n, t);
    }

    // Approach-2 (Bottom Up DP)
    // T.C : O(m*n)
    // S.C : O(m*n)
    
    public static void main(String[] args) {
        int[][] grid = {
                { 1, 3, 1 },
                { 1, 5, 1 },
                { 4, 2, 1 }
        };
        System.out.println(minPathSum(grid));
    }
}
