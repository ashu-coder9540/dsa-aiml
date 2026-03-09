public class AlternatingBinary {
    // Using Integer.toBinaryString() method
    public static boolean hasAlternatingBits1(int n) {
        String b = Integer.toBinaryString(n);
        for (int i = 1; i < b.length(); i++) {
            if (b.charAt(i) == b.charAt(i - 1))
                return false;
        }
        return true;
    }
    // Using & and >> operator
    public static boolean hasAlternatingBits2(int n) {
        int lastBit = n & 1;
        n = n >> 1;
        while (n > 0) {
            int currBit = n & 1;
            if (currBit == lastBit)
                return false;
            lastBit = currBit;
            n = n >> 1;
        }
        return true;
    }
    // Using % and / operator
    public static boolean hasAlternatingBits3(int n) {
        int lastBit = n % 2; // last bit extract
        n = n / 2;
        while (n > 0) {
            int currBit = n % 2;
            if (currBit == lastBit)
                return false;

            lastBit = currBit;
            n = n / 2;
        }
        return true;
    }
    // Using xor operator
    public static boolean hasAlternatingBits4(int n) {
        int res = n ^ (n >> 1); // take xor of right shift of n

        return (res & (res + 1)) == 0; // check res value are all set bit or not
    }

    public static void main(String[] args) {
        int n = 5;
        boolean result1 = hasAlternatingBits1(n);
        System.out.println(result1); // Output: true

        boolean result2 = hasAlternatingBits2(n);
        System.out.println(result2); // Output: true

        boolean result3 = hasAlternatingBits3(n);
        System.out.println(result3); // Output: true
        
        boolean result4 = hasAlternatingBits4(n);
        System.out.println(result4); // Output: true
    }
}
