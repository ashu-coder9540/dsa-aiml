import java.util.Arrays;

public class Level2 {
    public static void main(String[] args) {
        int[][] arr = {
                { 3, 4 },
                { 1, 2 },
                { 5, 0 }
        };
        // 1. Sort 2D Array by First Column
        Arrays.sort(arr, (a, b) -> a[0] - b[0]);
        for (int[] row : arr) {
            System.out.println(Arrays.toString(row));
        }
        System.out.println();
        // 2. Sort 2D Array by Second Column
        Arrays.sort(arr, (a, b) -> a[1] - b[1]);
        for (int[] row : arr) {
            System.out.println(Arrays.toString(row));
        }

        // 3. Sort Intervals by Start Time -> same as 2
        // 4. Sort Pairs by Second Value -> same as 2
        // 5. Sort Intervals by End Time (🔥 GREEDY) -> same as 2
        /*
         * 👉 Used in:
         * 
         * Activity Selection
         * Non-overlapping intervals
         * Meeting Rooms
         */

        // 6. Multi-Level Sorting (IMPORTANT🔥)
        /*
         * ✅ Problem 
         * Sort by: a) First column
         * If equal → second column
         */
        Arrays.sort(arr, (a, b) ->{
            return (a[0] == b[0]) ? (a[1] - b[1]) : (a[0] - b[0]);
        });

        // 7. Reverse Sorting in 2D Array
        Arrays.sort(arr, (a, b) -> b[0] - a[0]);
    }
}
