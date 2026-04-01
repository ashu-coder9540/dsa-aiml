public class CountSbMatrices {
    //Approach-1 (Brute Force)
    //T.C : O(m^2 * n^2)
    //S.C : O(1)
    public static int countSubmatrices(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;
        int count = 0;
        // BruteForce Approach
        for (int i = 0; i < m; i++) { //iterate till bottom left cell
            for (int j = 0; j < n; j++) {
                int sum = 0;
                for (int p = 0; p <= i; p++) {
                    for (int q = 0; q <= j; q++) { //iterating on submatrix
                        sum += grid[p][q];
                    }
                }
                if (sum <= k)
                    count++;
            }
        }
        return count;
    }
    // Approach-2 (Using precomputed results)
    // T.C : O(m*n)
    // S.C : O(1)
    public static int countSubmatrices2(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;
        int count = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                if (i > 0)
                    grid[i][j] += grid[i - 1][j];
                if (j > 0)
                    grid[i][j] += grid[i][j - 1];
                if (i > 0 && j > 0)
                    grid[i][j] -= grid[i - 1][j - 1];

                if (grid[i][j] <= k) {
                    count++;
                } else {
                    break;
                }
            }
        }

        return count;
    }

    public static void main(String[] args) {
        int[][] grid = {{1, 1, 1}, {1, 0, 1}, {1, 1, 0}};
        int k = 4;
        System.out.println(countSubmatrices(grid, k)); // Output: 6
        System.out.println(countSubmatrices2(grid, k)); // Output: 6
    }
}
