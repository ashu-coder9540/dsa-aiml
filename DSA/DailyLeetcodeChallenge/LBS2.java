public class LBS2 {
    private static boolean isBalanced(int[] freqMp) {
        int val = 0;

        for (int f : freqMp) {
            if (f > 0) {
                if (val == 0) {
                    val = f;
                } else if (f != val) {
                    return false;
                }
            }
        }
        return true;
    }

    public static int longestBalanced(String s) {
        // Using BruteForce
        int n = s.length();

        int maxLen = 0;
        for (int i = 0; i < n; i++) {
            int[] freqMp = new int[3];
            for (int j = i; j < n; j++) {
                freqMp[s.charAt(j) - 'a']++;

                if (isBalanced(freqMp)) {
                    maxLen = Math.max(maxLen, j - i + 1);
                }
            }
        }
        return maxLen;
    }

    public static void main(String[] args) {
        String s = "abcabc";
        int result = longestBalanced(s);
        System.out.println(result); // Output: 6
    }
}
