import java.util.Arrays;

public class StableBinary {
    static int M = 1_000_000_007;
    static int[][][] t = new int[201][201][2];

    private static int solve(int onesLeft, int zerosLeft, int lastWasOne, int limit) {
        if (onesLeft == 0 && zerosLeft == 0)
            return 1;
        if (t[onesLeft][zerosLeft][lastWasOne] != -1)
            return t[onesLeft][zerosLeft][lastWasOne];

        int result = 0;
        if (lastWasOne == 1) { // explore 0s
            for (int len = 1; len <= Math.min(zerosLeft, limit); len++) {
                result = (result + solve(onesLeft, zerosLeft - len, 0, limit)) % M;
            }
        } else { // explore 1s
            for (int len = 1; len <= Math.min(onesLeft, limit); len++) {
                result = (result + solve(onesLeft - len, zerosLeft, 1, limit)) % M;
            }
        }
        return t[onesLeft][zerosLeft][lastWasOne] = result;
    }

    // Approach-1 (Recursion + Memoization)
    // T.C : O(one * zero * limit)
    // S.C : O(one * zero)
    public static int numberOfStableArrays(int zero, int one, int limit) {
        for (int[][] a : t)
            for (int[] b : a)
                Arrays.fill(b, -1);
        int startWithOne = solve(one, zero, 0, limit);
        int startWithZero = solve(one, zero, 1, limit);
        return (startWithOne + startWithZero) % M;
    }

    // Approach-2 (Bottom Up)
    // T.C : O(one * zero * limit)
    // S.C : O(one * zero)
    public static int numberOfStableArraysBottomUp(int zero, int one, int limit) {
        int M = 1_000_000_007;
        int[][][] t = new int[one + 1][zero + 1][2];

        // Base case: solve(0,0,lastWasOne) = 1
        t[0][0][1] = 1;
        t[0][0][0] = 1;

        for (int onesLeft = 0; onesLeft <= one; onesLeft++) {
            for (int zerosLeft = 0; zerosLeft <= zero; zerosLeft++) {
                // Base Case
                if (onesLeft == 0 && zerosLeft == 0)
                    continue;

                int res = 0;
                // if(lastWasOne == true) { explore 0s }
                for (int len = 1; len <= Math.min(zerosLeft, limit); len++) {
                    res = (res + t[onesLeft][zerosLeft - len][0]) % M;
                }
                t[onesLeft][zerosLeft][1] = res;

                // else { explore 1s }
                res = 0;
                for (int len = 1; len <= Math.min(onesLeft, limit); len++) {
                    res = (res + t[onesLeft - len][zerosLeft][1]) % M;
                }
                t[onesLeft][zerosLeft][0] = res;
            }
        }
        int startWithOne = t[one][zero][0]; // solve(one, zero, false, limit)
        int startWithZero = t[one][zero][1]; // solve(one, zero, true, limit)
        return (startWithOne + startWithZero) % M;
    }

    public static void main(String[] args) {
        int zero1 = 1, one1 = 2, limit1 = 1;
        int zero2 = 3, one2 = 3, limit2 = 2;
        System.out.println(numberOfStableArrays(zero1, one1, limit1)); // Expected output: 1
        System.out.println(numberOfStableArrays(zero2, one2, limit2)); // Expected output: 14

        System.out.println(numberOfStableArraysBottomUp(zero1, one1, limit1)); // Expected output: 1
        System.out.println(numberOfStableArraysBottomUp(zero2, one2, limit2)); // Expected output: 14
    }
}
