public class CheckOnesSegment {
    // Approach - 1 (maintain a count of onesSegment)
    public static boolean checkOnesSegment(String s) {
        int n = s.length();

        int count = 0; // count of continuous segments of '1'

        int i = 0;
        while (i < n) {
            if (s.charAt(i) == '1') {
                count++;
                while (i < n && s.charAt(i) == '1') {
                    i++;
                }
            } else {
                i++;
            }
            if (count > 1) {
                return false;
            }
        }
        return true;
    }

        // Approach - 2 (check if there is any '01' pattern in the string)
    public static boolean checkOnesSegmentApproach2(String s) {
        return !s.contains("01");
    }

    public static void main(String[] args) {
        String s1 = "1001";
        String s2 = "110";
        String s3 = "1111"; 
        System.out.println(checkOnesSegment(s1)); // Expected output: false
        System.out.println(checkOnesSegment(s2)); // Expected output: true  
        System.out.println(checkOnesSegment(s3)); // Expected output: true  

        System.out.println(checkOnesSegmentApproach2(s1)); // Expected output: false
        System.out.println(checkOnesSegmentApproach2(s2)); // Expected output: true 
        System.out.println(checkOnesSegmentApproach2(s3)); // Expected output: true
    }
}
