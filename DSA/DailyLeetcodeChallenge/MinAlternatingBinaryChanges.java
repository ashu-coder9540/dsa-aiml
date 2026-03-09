public class MinAlternatingBinaryChanges {
     // Approach - 1
    public static int minOperations(String s) {
        int n = s.length();

        int st_With_0 = 0; //010101...
        int st_With_1 = 0; //101010... 

        for(int i=0; i<n; i++){
            if(i%2==0){ //even idx
                char ch = s.charAt(i);
                if(ch == '0'){
                    st_With_1++;
                }else{ //ch == '1'
                    st_With_0++;
                }
            }else{ //odd idx
                char ch = s.charAt(i);
                if(ch == '0'){
                    st_With_0++;
                }else{ //ch == '1'
                    st_With_1++;
                }
            }
        }
        return Math.min(st_With_0, st_With_1);
    }

     // Approach - 2 
    public static int minOperations2(String s) {
        int n = s.length();

        int st_With_0 = 0; //010101...

        for(int i=0; i<n; i++){
            if(i%2==0){ //even idx
                char ch = s.charAt(i);
                if(ch == '1'){
                    st_With_0++;
                }
            }else{ //odd idx
                char ch = s.charAt(i);
                if(ch == '0'){
                    st_With_0++;
                }
            }
        }
        int st_With_1 = n-st_With_0;
        return Math.min(st_With_0, st_With_1);
    }
    public static void main(String[] args) {
        String s1 = "0100";
        String s2 = "10010100";
        String s3 = "1111";

        System.out.println(minOperations(s1)); // Expected output: 1
        System.out.println(minOperations(s2)); // Expected output: 3
        System.out.println(minOperations(s3)); // Expected output: 2

        System.out.println(minOperations2(s1)); // Expected output: 1
        System.out.println(minOperations2(s2)); // Expected output: 3   
        System.out.println(minOperations2(s3)); // Expected output: 2
    }
}
