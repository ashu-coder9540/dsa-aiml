public class ReverseString {
      public static void reverseString(char[] s) {
        int n = s.length;
        int l = 0, r = n-1;
        while(l<r){
            char temp = s[l];
            s[l] = s[r];
            s[r] = temp;

            l++;
            r--;
        }
    }
    public static void main(String[] args) {
        char[] s = {'h', 'e', 'l', 'l', 'o'};
        for(char ch: s){
             System.out.print(ch +" ");
        }
        System.out.println();
        reverseString(s);
        
        for(char ch: s){
             System.out.print(ch+" ");
        }
    }
}
