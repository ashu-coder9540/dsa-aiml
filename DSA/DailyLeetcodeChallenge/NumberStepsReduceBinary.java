public class NumberStepsReduceBinary {
    private static void addOne(StringBuilder s) {
        int i = s.length() - 1;

        while (i >= 0 && s.charAt(i) != '0') {
            s.setCharAt(i, '0');
            i--;
        }
        // If all bits were 1
        if (i < 0) {
            s.insert(0, '1');
        } else {
            s.setCharAt(i, '1');
        }
    }

    // TC :- O(n^2) in worst case when all bits are 1, we need to add 1 for n times and each addition takes O(n) time
    // SC :- O(n) for the StringBuilder
    public static int numSteps(String s) {
        StringBuilder sb = new StringBuilder(s);
        int steps = 0;
        while (sb.length() > 1) {
            int n = sb.length();
            char currChar = sb.charAt(n - 1);
            if (currChar == '0') {
                // even number -> divide by 2
                sb.deleteCharAt(n - 1);
            } else {
                // odd number -> add 1
                addOne(sb);
            }
            steps++;
        }
        return steps;
    }

    // Optimized approach: TC :- O(n) and SC :- O(1)
    public static int numStepsOptimized(String s) {       
        int n = s.length();
        int steps = 0, carry = 0;
        for (int i = n - 1; i >= 1; i--) {
            if (((s.charAt(i) - '0') + carry) % 2 != 0) {
                // num is odd -> steps += 2
                steps += 2;
                carry = 1;
            } else {
                // num is even -> steps += 1
                steps += 1;
            }
        }
        return steps + carry;
    }

    public static void main(String[] args) {
        System.out.println(numSteps("1101")); // Expected output: 6
        System.out.println(numSteps("10")); // Expected output: 1
        System.out.println(numSteps("1")); // Expected output: 0

        System.out.println(numStepsOptimized("1101")); // Expected output: 6
        System.out.println(numStepsOptimized("10")); // Expected output: 1
        System.out.println(numStepsOptimized("1")); // Expected output: 0
    }
}
