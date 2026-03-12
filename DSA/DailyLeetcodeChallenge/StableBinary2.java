
public class StableBinary2 {
    static int M = 1_000_000_007;

    public static int numberOfStableArrays(int zero, int one, int limit) {
        int[][][] t = new int[zero + 1][one + 1][2];

        // Base Cases
        for (int i = 1; i <= Math.min(zero, limit); i++) {
            t[i][0][0] = 1;
        }
        for (int j = 1; j <= Math.min(one, limit); j++) {
            t[0][j][1] = 1;
        }

        for (int i = 0; i <= zero; i++) { //i = #zeros 
            for (int j = 0; j <= one; j++) { //j = #ones
                if (i == 0 || j == 0)
                    continue;

                // end with 0 
                int val0 = (t[i - 1][j][0] + t[i - 1][j][1]) % M;

                if (i - 1 >= limit)
                    val0 = (val0 - t[i - 1 - limit][j][1] + M) % M;

                t[i][j][0] = val0;

                // end with 1
                int val1 = (t[i][j - 1][0] + t[i][j - 1][1]) % M;

                if (j - 1 >= limit)
                    val1 = (val1 - t[i][j - 1 - limit][0] + M) % M;
                t[i][j][1] = val1;
            }
        }
        return (t[zero][one][0] + t[zero][one][1]) % M;
    }
    public static void main(String[] args) {
        System.out.println(numberOfStableArrays(1, 1, 2)); // Output: 2
        System.out.println(numberOfStableArrays(1, 2, 1)); // Output: 1
        System.out.println(numberOfStableArrays(3, 3, 2)); // Output: 14
    }
}
