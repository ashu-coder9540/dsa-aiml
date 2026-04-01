public class CyclicMatrixShift {
    // Approach-1 (Simulation + extra space + our own rotation logic)
    // T.C : O(m*n)
    // S.C : O(m*n)
    private static void rotateLeft(int[] row, int k) {
        reverse(row, 0, k - 1);
        reverse(row, k, row.length - 1);
        reverse(row, 0, row.length - 1);
    }

    private static void rotateRight(int[] row, int k) {
        int n = row.length;
        rotateLeft(row, n - k);
    }

    private static void reverse(int[] row, int l, int r) {
        while (l < r) {
            int temp = row[l];
            row[l] = row[r];
            row[r] = temp;
            l++;
            r--;
        }
    }

    public static boolean areSimilar(int[][] mat, int k) {
        int m = mat.length;
        int n = mat[0].length;

        k = k % n; // Handle cases where k >= n
        if (k == 0)
            return true;

        // Copy Matrix
        int[][] temp = new int[m][n];
        for (int i = 0; i < m; i++) {
            temp[i] = mat[i].clone();
        }

        for (int i = 0; i < m; i++) {
            if (i % 2 == 0) { // Even row
                // left shift
                rotateLeft(mat[i], k);
            } else { // Odd row
                 // right shift
                rotateRight(mat[i], k);
            }
        }
        // Compare original with temp
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] != temp[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[][] mat = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
        int k = 3;
        System.out.println(areSimilar(mat, k)); // Output: true

    }
}
