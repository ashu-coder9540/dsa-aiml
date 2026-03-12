public class BitsComplement {
    // Approach - 1
    // TC = O(logn)
    // SC = O(1)
    public static int bitwiseComplement(int n) {
        if(n == 0) return 1;
        int res = 0, counter = 0;
        while(n!=0){
            int r = n%2;
            res += (int)(Math.pow(2, counter++)*(r==0 ? 1 : 0));
            n = n >> 1;
        }
        return res;
    }
     // Approach - 2
    // TC = O(logn)
    // SC = O(1)
    public static int bitwiseComplement2(int n) {
        if(n == 0) return 1;

        int mask = 1;
        while(mask<n){
            mask = (mask << 1) | 1;
        }
        return mask ^ n;
    }
     // Approach - 3
    // TC = O(1)
    // SC = O(1)
    public static int bitwiseComplement3(int n) {
        if(n==0) return 1;
        int bits = (int)(Math.log(n)/Math.log(2)) + 1; //bits = log2(n) + 1
        int mask = (1<<bits) - 1; //mask = 2^bits - 1
        return mask ^ n;
    }
    public static void main(String[] args) {
        System.out.println(bitwiseComplement(5)); // Output: 2
        System.out.println(bitwiseComplement(7)); // Output: 0
        System.out.println(bitwiseComplement(10)); // Output: 5

        System.out.println(bitwiseComplement2(5)); // Output: 2
        System.out.println(bitwiseComplement2(7)); // Output: 0
        System.out.println(bitwiseComplement2(10)); // Output: 5

        System.out.println(bitwiseComplement3(5)); // Output: 2
        System.out.println(bitwiseComplement3(7)); // Output: 0
        System.out.println(bitwiseComplement3(10)); // Output: 5
    }
}
