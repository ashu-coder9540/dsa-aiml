public class MinDeciBinary {
    // Approach-1
     //Method-1 (This method explains why Method-2 trick worked)
    //T.C : O(n*D), where D is the max digit which can be <= 9 ~= O(n)
    //S.C : O(1)
    public static int minPartitions(String n) {
        char[] arr = n.toCharArray();
        int count = 0;

        while (true) {
            boolean changed = false;

            for (int i = 0; i < arr.length; i++) {
                if (arr[i] != '0') {
                    arr[i]--; // subtract 1
                    changed = true;
                }
            }

            if (!changed)
                break;

            count++;
        }

        return count;
    }
    // Approach-2
    // T.C : o(length)
    // S.C : O(1)
    public static int minPartitions2(String n) {
        char maxCh = '0';

        for (char ch : n.toCharArray()) {
            maxCh = (char) Math.max(maxCh, ch);
        }

        return maxCh - '0';
    }

    public static void main(String[] args) {
        System.out.println(minPartitions("32")); // Expected output: 3
        System.out.println(minPartitions("82734")); // Expected output: 8
        System.out.println(minPartitions("27346209830709182346")); // Expected output: 9

        System.out.println(minPartitions2("32")); // Expected output: 3 
        System.out.println(minPartitions2("82734")); // Expected output: 8
        System.out.println(minPartitions2("27346209830709182346")); // Expected output: 9
    }
}
