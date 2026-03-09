public class ConcatenatedBinary {
    // Approach-1 (Using lo2(n) to find bits count)
    // T.C : O(n)
    // S.C : O(1)
    public static int concatenatedBinary(int n) {
        long res = 0;
        int M = 1_000_000_007;

        for (int i = 1; i <= n; i++) {
            int digits = (int) (Math.log(i) / Math.log(2)) + 1;
            res = ((res << digits) % M + i) % M;
        }
        return (int) res;
    }

    // Approach-2 
    // T.C : O(n)       
    // S.C : O(1)
    public static int concatenatedBinary2(int n) {
        long res = 0;
        int M = 1_000_000_007;
        int digits = 0;
        for(int i=1; i<=n; i++){
            // if i is in power of 2 digits increased by 1
           if((i & (i-1)) == 0) digits++;
            res = ((res << digits) % M + i) % M;
        }
        return (int) res;
    }
    public static void main(String[] args) {
        System.out.println(concatenatedBinary(1)); // Expected output: 1
        System.out.println(concatenatedBinary(3)); // Expected output: 27
        System.out.println(concatenatedBinary(12)); // Expected output: 505379714

        System.out.println(concatenatedBinary2(1)); // Expected output: 1
        System.out.println(concatenatedBinary2(3)); // Expected output: 27
        System.out.println(concatenatedBinary2(12)); // Expected output: 505379714
    }
}
