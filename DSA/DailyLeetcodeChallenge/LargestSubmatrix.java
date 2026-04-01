/* import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class LargestSubmatrix {
    static class Pair {
    int height;
    int col;

    public Pair(int height, int col) {
        this.height = height;
        this.col = col;
    }
}
    // Approach-1 (Brute Force)
    // T.C : O(m*n * min(m, n)^2)
    // S.C : O(1)
    public static int largestSubmatrix(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int maxArea = 0;

        for (int row = 0; row < m; row++) {
            for (int col = 0; col < n; col++) {
                if (matrix[row][col] == 1 && row > 0) {
                    matrix[row][col] += matrix[row - 1][col]; // cumulative 1's continuous
                }
            }
            int[] currRow = matrix[row].clone();
            Arrays.sort(currRow); // sort currRow in increasing order

            for (int col = 0; col < n; col++) {
                int base = (n - col); // base start from curr col to last col
                int height = currRow[col];
                maxArea = Math.max(maxArea, base * height);
            }
        }
        return maxArea;
    }

    // Approach-2 (Without modifying the given input)
    // T.C : (m * nlogn)
    // S.C : O(m*n)

    public static int largestSubmatrix2(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int maxArea = 0;

        int[] prevRow = new int[n];

        for (int row = 0; row < m; row++) {
            int[] currRow = matrix[row].clone();
            for (int col = 0; col < n; col++) {
                if (currRow[col] == 1) {
                    currRow[col] += prevRow[col]; // cumulative 1's continuous
                }
            }

            int[] sortedRow = currRow.clone();
            Arrays.sort(sortedRow); // sort currRow in increasing order

            for (int col = 0; col < n; col++) {
                int base = (n - col); // base start from curr col to last col
                int height = sortedRow[col];
                maxArea = Math.max(maxArea, base * height);
            }
            prevRow = currRow;
        }
        return maxArea;
    }

    // Approach-3 (Without sorting)
    // T.C : O(m*n)
    // S.C : O(m*n)

    // public static int largestSubmatrix3(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        List<Pair<Integer, Integer>> prevRow = new ArrayList<>(); // It store prevRow (height, col) pair in list
        int maxArea = 0;

        for (int row = 0; row < m; row++) {
            List<Pair<Integer, Integer>> currRow = new ArrayList<>(); // It store currRow (height, col) pair in list
            boolean[] visited = new boolean[n]; // It marked the visited element in matrix

            for (var entry : prevRow) {
                int height = entry.getKey();
                int col = entry.getValue();

                if (matrix[row][col] == 1) {
                    currRow.add(new Pair<>(height + 1, col));
                    visited[col] = true;
                }
            }

            for (int col = 0; col < n; col++) {
                if (!visited[col] && matrix[row][col] == 1) {
                    currRow.add(new Pair<>(1, col));
                }
            }

            for (int i = 0; i < currRow.size(); i++) {
                int base = i + 1;
                int height = currRow.get(i).getKey();
                maxArea = Math.max(maxArea, base * height);
            }
            prevRow = currRow;
        }
        return maxArea;
    }

    public static void main(String[] args) {
        int[][] matrix = {
                { 0, 0, 1 },
                { 1, 1, 1 },
                { 1, 0, 0 }
        };
        System.out.println(largestSubmatrix(matrix)); // Output: 3
    }
}
 */